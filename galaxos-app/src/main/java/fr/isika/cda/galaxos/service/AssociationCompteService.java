package fr.isika.cda.galaxos.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.repository.AssociationRepository;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;

@Stateless
public class AssociationCompteService {

	@Inject
	private AssociationRepository associationRepository;

	public AssociationCompteService() {
	}

	public Association create(AssociationCreationForm associationCreationForm) {
		return associationRepository.create(associationCreationForm);
	}
}
