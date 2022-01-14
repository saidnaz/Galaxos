package fr.isika.cda.galaxos.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.dto.ResourceAddForm;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.model.roles.Provider;
import fr.isika.cda.galaxos.repository.ResourceRepo;

@Stateless
public class ResourceService {

	@Inject
	private ResourceRepo resRepo;
	
	public ResourceService() {}
	
	public Resource create(ResourceAddForm form) {
		
		return resRepo.create(form);
	}
	
	public List<Provider> findProviderByAdh(Long id) {
		return resRepo.findProviderByAdh(id);
	}
	
	public List<Resource> findAll(){
		return resRepo.findAll();
	}
	
	public List<Resource> findByAssociation(Long idAsso){
		System.out.println("je suis ds le service");
		return resRepo.findByAssociation(idAsso);
	}
	
	public List<Association> findAssociationByAdherent(Long idAdh){
		return resRepo.findAssociationsAdherentParAdherent(idAdh);
	}
}
