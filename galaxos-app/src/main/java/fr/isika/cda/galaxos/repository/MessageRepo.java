package fr.isika.cda.galaxos.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public List<Message> mesMessages()
	{
		List<Message> listMsg = new ArrayList<>();
		listMsg = manager.createNamedQuery("Message.findMyList").getResultList();
		return listMsg;
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> allMessages()
	{
		List<Message> listMsg = new ArrayList<Message>();
		listMsg = manager.createNamedQuery("Message.findAll").getResultList();
		return listMsg;
	}
	
	
	
}
