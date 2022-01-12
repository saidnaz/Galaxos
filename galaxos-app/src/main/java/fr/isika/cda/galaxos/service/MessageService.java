package fr.isika.cda.galaxos.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.dto.MessagerieDTO;
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
	
	public List<MessagerieDTO> afficherContacts(Adherent moi)
	{
		List<Message> lAllMsg = msgRepo.allMessages();
		List<MessagerieDTO> lContact = new ArrayList<MessagerieDTO>();
		
		List<Long> idContact = new ArrayList<Long>();
		idContact.add(moi.getId());
		
		MessagerieDTO msgDTO = new MessagerieDTO();
		
		for (int i=lAllMsg.size()-1; i >= 0; i--)		// inverser la boucle si le dernierMessage afficher dans contact n'est pas bon
		{
			Long msgDestId = lAllMsg.get(i).getDestinataire().getId();
			Long msgExpId = lAllMsg.get(i).getExpediteur().getId();
			
			if(msgDestId == moi.getId() || msgExpId == moi.getId())
			{
				if (!idContact.contains(msgDestId) ||  !idContact.contains(msgExpId))
				{
					msgDTO.setLastMsg(lAllMsg.get(i));
				
					if (msgExpId != moi.getId())
					{
						idContact.add(msgExpId);
						msgDTO.setContact(lAllMsg.get(i).getExpediteur());
					}
					else {
						idContact.add(msgDestId);
						msgDTO.setContact(lAllMsg.get(i).getDestinataire());
					}
					lContact.add(msgDTO);
				}
			}
		}
		
		return lContact;
	}
	
}
