package fr.isika.cda.galaxos.dto;

import java.util.List;

import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Profil;

public class MessageDTO {

	private List<Message> lMsg;
	
	private Profil destinataire;
	
	private Profil expediteur;

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

	
	
}