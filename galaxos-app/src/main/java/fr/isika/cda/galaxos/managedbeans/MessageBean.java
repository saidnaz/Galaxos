package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.dto.MessageDTO;
import fr.isika.cda.galaxos.dto.MessagerieDTO;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.model.roles.Role;
import fr.isika.cda.galaxos.service.MessageService;



@ManagedBean(name="MessageBean")
@ViewScoped
public class MessageBean implements Serializable {

	private static final long serialVersionUID = -6491967124514940460L;


	@Inject
	private MessageService messageService;
	
	private Profil profilDestinataire;	// Pour la liste des messages, pas la liste des contacts (messagerie)
	
	private Profil profilExpediteur;
	
	private MessagerieDTO messagerieDTO;	// Liste des contacts
	
	private MessageDTO messageDTO;		// ViewModel est délcaré ici dans le bean
	
	@NotEmpty(message = "")
	@NotNull(message = "")
	@Size(min = 1, max = 500, message = "")
	private String text;
	

	
	// Initialisation : Lors du lancement du serv, lance les méthodes à l'intérieur du init
	@PostConstruct
	private void init() {
		
	}
	
	private void afficherMessages(Profil profilDest) {
		
		profilDestinataire = profilDest;
		
		messageDTO = messageService.chargerMessages();

	}
	
	
	
	public String envoyer()
	{
		Message msg = new Message();
		msg.setTexte(text);
		msg.setDate(LocalDateTime.now());
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Profil profilExpediteur = (Profil) session.getAttribute("profil");
		List<Role> lRoles = (List<Role>) session.getAttribute("roles");
		// Dans loginbean, assigné un attribut profil à httpsession
		
		msg.setExpediteur(profilExpediteur);
		msg.setDestinataire(profilDestinataire);
		
		messageService.envoyer(msg);
					
		afficherMessages(profilDestinataire);
		
		// return "index?faces-redirect=true"; 	// // return "index?faces-redirect=true"; 	// remet les paramètres de la page (des classes) à zero.
		 return "messages";		// rester sur la même page en vidant les infos du formulaire
		// return "" 	// rester sur la même page (en gardant les infos du formulaire)
	}
	
	public void afficher()
	{
		//messageService.
	}


	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public MessageDTO getMessageDTO() {
		return messageDTO;
	}
	
	public void setMessageDTO(MessageDTO messageDTO) {
		this.messageDTO = messageDTO;
	}

	public Profil getProfilDestinataire() {
		return profilDestinataire;
	}

	public void setProfilDestinataire(Profil profilDestinataire) {
		this.profilDestinataire = profilDestinataire;
	}
	
	public Profil getProfilExpediteur() {
		return profilExpediteur;
	}

	public void setProfilExpediteur(Profil profilExpediteur) {
		this.profilExpediteur = profilExpediteur;
	}

	public MessagerieDTO getMessagerieDTO() {
		return messagerieDTO;
	}

	public void setMessagerieDTO(MessagerieDTO messagerieDTO) {
		this.messagerieDTO = messagerieDTO;
	}

	
	
	
	
}
