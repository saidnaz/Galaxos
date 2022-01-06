package fr.isika.cda.galaxos.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.service.MessageService;



@ManagedBean(name="MessageBean")
@ViewScoped
public class MessageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6491967124514940460L;


	@Inject
	private MessageService messageService;
	
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 500, message = "Doit être entre 1 et 500 caractère.")
//	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String text;
	
	private LocalDateTime date;

/*	
	private Adherent destinataire;

	private Adherent expediteur;
*/	
	
	public String envoyer(int idEmeteur) {
			
		System.out.println("Entrer dans la méthode envoyer du MessageBean");
		
			// remplissage de l'entité 
			Message msg = new Message();
			msg.setTexte(text);
			msg.setDate(LocalDateTime.now());
			
			// Remplacer dans le modele "message" par Adherent emeteur
			// + Changer en attrapant l'id de l'utilisateur connecté grace au claim dans l'authentification, ou avec un hostmanager ?
			msg.setIdEmeteur(idEmeteur);
			
			// Remplacer la condition :
			// -> Quand on clic sur le contact, déclenche une méthode qui prend en paramètre l'id du destinataire
			if (idEmeteur == 1)
			{
				msg.setIdDestinataire(2);
			}
			else msg.setIdDestinataire(1);

			System.out.println("text : " + text);
			
			// appeler le service pour sauvegarder l'entité 
			messageService.envoyer(msg);

			
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
}
