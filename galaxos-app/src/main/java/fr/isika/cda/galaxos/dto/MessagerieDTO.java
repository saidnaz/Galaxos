package fr.isika.cda.galaxos.dto;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;

public class MessagerieDTO {

private List<Message> lMsg;	// Appeler text + Date
	
	private List<String> lNomDestinataire;	// Peut être pas besoin plus tard, car à partir de la liste de message on pourra appeler msg.destinataire.prenom ?

	private String recherche;	// Rechercher le nom d'un contact ou contenu d'un message -> Filtre les Contacts concernés par la recherche
	
	public MessagerieDTO() {
		super();
	}

	public MessagerieDTO(List<Message> lMsg, List<String> lNomDestinataire) {
		super();
		this.lMsg = lMsg;
		this.lNomDestinataire = lNomDestinataire;
	}

	public List<Message> getlMsg() {
		return lMsg;
	}

	public void setlMsg(List<Message> lMsg) {
		this.lMsg = lMsg;
	}
	
	public void addlMsg(Message msgToAdd) {
		this.lMsg.add(msgToAdd);
	}

	public List<String> getlNomDestinataire() {
		return lNomDestinataire;
	}

	public void setlNomDestinataire(List<String> lNomDestinataire) {
		this.lNomDestinataire = lNomDestinataire;
	}

	public void addlNomDestinataire(String nomDestinataire) {
		this.lNomDestinataire.add(nomDestinataire);
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	
}
