package fr.isika.cda.galaxos.dto;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;

public class MessageDTO {

	private List<Message> lMsg;
	
	private List<String> lNomDestinataire;

	public MessageDTO() {
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