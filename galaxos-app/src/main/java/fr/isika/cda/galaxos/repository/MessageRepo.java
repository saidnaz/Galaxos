package fr.isika.cda.galaxos.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.dto.MessageDTO;
import fr.isika.cda.galaxos.model.Message;

@Stateless
public class MessageRepo {

	@PersistenceContext
	private EntityManager manager;
	
	public Message envoyer (Message msg)
	{
		try {
			this.manager.persist(msg);
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public MessageDTO afficher()
	{
		MessageDTO msgDTO = new MessageDTO();
		msgDTO.setlMsg(manager.createNamedQuery("Message.findAll").getResultList());
		return msgDTO;
	}
	
	
	
	
	
}
