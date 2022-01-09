package fr.isika.cda.galaxos.dto;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;

public class MessagerieDTO {

private Message msg;	// Appeler text + Date
	
	private String lNomDestinataire;	// Peut être pas besoin plus tard, car à partir de la liste de message on pourra appeler msg.destinataire.prenom ?

//	private String recherche;	// Rechercher le nom d'un contact ou contenu d'un message -> Filtre les Contacts concernés par la recherche
	
	public MessagerieDTO() {
		super();
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public String getlNomDestinataire() {
		return lNomDestinataire;
	}

	public void setlNomDestinataire(String lNomDestinataire) {
		this.lNomDestinataire = lNomDestinataire;
	}
	
}
