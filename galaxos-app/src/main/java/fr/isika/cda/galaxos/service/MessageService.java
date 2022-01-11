package fr.isika.cda.galaxos.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.dto.MessageDTO;
import fr.isika.cda.galaxos.model.Adherent;
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
	
	public List<Message> afficherMessages(Adherent autreAd, Adherent moi) {
		List<Message> lAllMsg = msgRepo.allMessages();
		List<Message> lMsg = new ArrayList<Message>();
		
		
		
		
		
		for (int i=0; i < lAllMsg.size(); i++)
		{
			Long msgDestId = lAllMsg.get(i).getDestinataire().getId();
			Long msgExpId = lAllMsg.get(i).getExpediteur().getId();
			
			if(msgDestId == moi.getId() && msgExpId == autreAd.getId()  || msgExpId == moi.getId() && msgDestId == autreAd.getId())
			{
				lMsg.add(lAllMsg.get(i));
			}
		}
		
		return lMsg;
	}
	
	public List<Message> afficherContacts(Adherent moi)
	{
		List<Message> lAllMsg = msgRepo.allMessages();
		List<Message> lContact = new ArrayList<Message>();
		List<Long> idContact = new ArrayList<Long>();
		idContact.add(moi.getId());
		
		for (int i=0; i < lAllMsg.size(); i++)
		{
			Long msgDestId = lAllMsg.get(i).getDestinataire().getId();
			Long msgExpId = lAllMsg.get(i).getExpediteur().getId();
			
			if(msgDestId == moi.getId() || msgExpId == moi.getId())
			{
				if (!idContact.contains(msgDestId) ||  !idContact.contains(msgExpId))
				{
					lContact.add(lAllMsg.get(i));
				}
					if (msgExpId != moi.getId())
					{
						idContact.add(msgExpId);
					}
					else idContact.add(msgDestId);
			}
		}
		
		return lContact;
	}
	
}
