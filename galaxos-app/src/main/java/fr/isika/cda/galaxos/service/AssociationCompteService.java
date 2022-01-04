package fr.isika.cda.galaxos.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.FicheAssoCompta;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.model.FicheAssoGestionnaire;
import fr.isika.cda.galaxos.repository.AssociationRepository;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@Stateless
public class AssociationCompteService {

	@Inject
	private AssociationRepository associationRepository;

	public AssociationCompteService() {
	}

	public Association create(AssociationCreationForm associationCreationForm) {
		return associationRepository.create(associationCreationForm);
	}

	public FicheAssoDescriptif creationFicheAssoDescriptif(AssociationFinalisationForm form) {
		return associationRepository.creationFicheAssoDescriptif(form);
	}

	public FicheAssoGestionnaire creationFicheAssoGestionnaire(AssociationFinalisationForm form) {
		return associationRepository.creationFicheAssoGestionnaire(form);
	}

	public FicheAssoCompta creationFicheAssoCompta(AssociationFinalisationForm form) {
		return associationRepository.creationFicheAssoCompta(form);
	}
}
