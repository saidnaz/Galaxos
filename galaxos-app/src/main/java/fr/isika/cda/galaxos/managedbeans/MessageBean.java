package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.dto.MessagerieDTO;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.MessageService;



@ManagedBean(name="MessageBean")
@ViewScoped
public class MessageBean implements Serializable {

	private static final long serialVersionUID = -6491967124514940460L;


	@Inject
	private MessageService messageService;
	
	private Adherent destinataire;	// Pour la liste des messages, pas la liste des contacts (messagerie)
	
	private Adherent expediteur;
	
	private List<MessagerieDTO> messagerieDTO;	// Liste des contacts
	
	private List<Message> messageDTO;		// ViewModel est délcaré ici dans le bean
	
	
	
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 500, message = "")
	private String text;
	
	
	
	// Initialisation : Lors du lancement du serv, lance les méthodes à l'intérieur du init
	@PostConstruct
	private void init() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		expediteur = (Adherent) session.getAttribute("connectedAdherent");
		afficherContacts(this.expediteur);
	}
	
	public void afficherMessages(Adherent expediteur, Adherent destinataire) {
		messageDTO = messageService.afficherMessages(expediteur, destinataire);
	}
	
	public void actualiserMessages(Adherent destinaire)
	{
		this.destinataire = destinaire;
		afficherMessages(expediteur, destinataire);
	}
	
	
	public void afficherContacts(Adherent expediteur)
	{
		messagerieDTO = messageService.afficherContacts(expediteur);
		// appeler methode afficher messages pour charger la nouvelle liste à afficher, et faire un redirect sur la page
	}
	
	public void voirProfil (Profil destinataire)
	{
		
	}
	
	public String envoyer()
	{		
		Message msg = new Message();
		msg.setTexte(text);
		msg.setDate(LocalDateTime.now());
		
		msg.setExpediteur(expediteur);
		msg.setDestinataire(destinataire);
		
		messageService.envoyer(msg);
					
		afficherMessages(expediteur, destinataire);	// Actualiser la vue message après l'envoie pour voir le message envoyé apparaitre à la liste des autres messages
		
		// return "index?faces-redirect=true"; 	// // return "index?faces-redirect=true"; 	// remet les paramètres de la page (des classes) à zero.
		 return "messages";		// rester sur la même page en vidant les infos du formulaire
		// return "" 	// rester sur la même page (en gardant les infos du formulaire)
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

	public Adherent getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Adherent destinataire) {
		this.destinataire = destinataire;
	}

	public Adherent getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Adherent expediteur) {
		this.expediteur = expediteur;
	}

	public List<MessagerieDTO> getMessagerieDTO() {
		return messagerieDTO;
	}

	public void setMessagerieDTO(List<MessagerieDTO> messagerieDTO) {
		this.messagerieDTO = messagerieDTO;
	}

	public List<Message> getMessageDTO() {
		return messageDTO;
	}

	public void setMessageDTO(List<Message> messageDTO) {
		this.messageDTO = messageDTO;
	}
	
	

	
	
	
	
}
