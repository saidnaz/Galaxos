package fr.isika.cda.galaxos.dto;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;

public class MessagerieDTO {

private Message messagerieDTO;	// Appeler text + Date
	
//	private List<String> lNomDestinataire;	// Peut être pas besoin plus tard, car à partir de la liste de message on pourra appeler msg.destinataire.prenom ?

	private String recherche;	// Rechercher le nom d'un contact ou contenu d'un message -> Filtre les Contacts concernés par la recherche
	
	public MessagerieDTO() {
		super();
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	
}
