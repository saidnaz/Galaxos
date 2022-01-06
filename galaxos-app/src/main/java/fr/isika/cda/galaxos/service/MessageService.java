package fr.isika.cda.galaxos.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.repository.MessageRepo;

@Stateless
public class MessageService {

	@Inject
	private MessageRepo msgRepo;
	
	public Message envoyer (Message msg)
	{
		return msgRepo.envoyer(msg);
	}
	
	
	
}
