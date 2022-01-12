package fr.isika.cda.galaxos.dto;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Message;

public class MessagerieDTO {

private Message lastMsg;	// Appeler text + Date
	
	private Adherent contact;	// Peut être pas besoin plus tard, car à partir de la liste de message on pourra appeler msg.destinataire.prenom ?

	private String recherche;	// Rechercher le nom d'un contact ou contenu d'un message -> Filtre les Contacts concernés par la recherche
	
	public MessagerieDTO() {
		super();
		lastMsg = new Message();
		contact = new Adherent();
		recherche = "";
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public Message getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(Message lastMsg) {
		this.lastMsg = lastMsg;
	}

	public Adherent getContact() {
		return contact;
	}

	public void setContact(Adherent contact) {
		this.contact = contact;
	}

	

	
}
