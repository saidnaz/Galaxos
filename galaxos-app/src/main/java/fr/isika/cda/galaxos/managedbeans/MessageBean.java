package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.dto.MessagerieDTO;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.service.MessageService;

@ManagedBean(name = "MessageBean")
@RequestScoped
public class MessageBean implements Serializable {

	private static final long serialVersionUID = -6491967124514940460L;

	@Inject
	private AdherentService adherentService;

	@Inject
	private MessageService messageService;

	private Adherent destinataire; // Pour la liste des messages, pas la liste des contacts (messagerie)

	private Adherent expediteur;

	private List<MessagerieDTO> messagerieDTO; // Liste des contacts

	private List<Message> messageDTO; // ViewModel est délcaré ici dans le bean

	private int role;

	@NotEmpty
	@NotNull
	@Size(min = 1, max = 500, message = "")
	private String text;

	public String connected() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		boolean isConnected = (boolean) session.getAttribute("isConnected");
		if (!isConnected) {
			return "index.xhtml";
		}
		return "";
	}

	// Initialisation : Lors du lancement du serv, lance les méthodes à l'intérieur
	// du init
	@PostConstruct
	private void init() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		expediteur = (Adherent) session.getAttribute("connectedAdherent");

//		int count = (int) session.getAttribute("count");

		if (expediteur.getRole().contains("User")) {
			this.role = 1;
		} else
			this.role = 0;

		afficherContacts(this.expediteur);

		if (!messagerieDTO.isEmpty()) {
			destinataire = messagerieDTO.get(0).getContact();
			messageDTO = messageService.obtenirMessages(expediteur, destinataire);
		} else {
			List<Message> messageDTOvide = new ArrayList<>();
			messageDTO = messageDTOvide;
		}

			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
			String idString = params.get("contactAdherent");

			if (idString != null) {
				Long idContact = Long.parseLong(idString);

				// Caused by: java.lang.IllegalArgumentException: Could not locate named parameter [id], expecting one of [id_param]
				// at org.hibernate@5.3.13.Final//org.hibernate.query.internal.ParameterMetadataImpl.getNamedParameterDescriptor(ParameterMetadataImpl.java:218)
				// at deployment.galaxos-app.war//fr.isika.cda.galaxos.repository.AdherentRepository.findById(AdherentRepository.java:131)
				
				// on chercher le contact en question
				Optional<Adherent> optional = adherentService.findAdherentById(idContact);
				if (optional.isPresent()) {
					this.destinataire = optional.get();
					actualiserMessages(destinataire);
				}
			}

		}
//		session.setAttribute("count", 1);
	

	public void obtenirMessages(Adherent expediteur, Adherent destinataire) {
		messageDTO = messageService.obtenirMessages(expediteur, destinataire);
	}

	public void actualiserMessages(Adherent destinaire) {
		if (destinataire != null) {
			this.destinataire = destinaire;
			obtenirMessages(expediteur, destinataire);
		}

	}

	public void afficherContacts(Adherent expediteur) {
		messagerieDTO = messageService.obtenirContacts(expediteur);
		// appeler methode afficher messages pour charger la nouvelle liste à afficher,
		// et faire un redirect sur la page
	}

	public void goToMessagerie() {

	}

	public void voirProfil(Profil destinataire) {

	}

	public String envoyer() {
		Message msg = new Message();
		msg.setTexte(text);
//		msg.setDate(LocalDateTime.now());

		msg.setExpediteur(expediteur);
		msg.setDestinataire(destinataire);

		messageService.envoyer(msg);

		obtenirMessages(expediteur, destinataire); // Actualiser la vue message après l'envoie pour voir le message
													// envoyé apparaitre à la liste des autres messages

		// return "index?faces-redirect=true"; // // return "index?faces-redirect=true";
		// // remet les paramètres de la page (des classes) à zero.
		return "messagerie"; // rester sur la même page en vidant les infos du formulaire
		// return "" // rester sur la même page (en gardant les infos du formulaire)
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public AdherentService getAdherentService() {
		return adherentService;
	}

	public void setAdherentService(AdherentService adherentService) {
		this.adherentService = adherentService;
	}

}
