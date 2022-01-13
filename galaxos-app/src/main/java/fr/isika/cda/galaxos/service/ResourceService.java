package fr.isika.cda.galaxos.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.dto.ResourceAddForm;
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
}
