package fr.isika.cda.galaxos.dao;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;

public class MessageDAO {

	private List<Message> lMsg;
	
	private List<String> lNomDestinataire;

	public MessageDAO() {
		super();
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
	
}
