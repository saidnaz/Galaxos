package fr.isika.cda.galaxos.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.galaxos.exceptions.NomAssociationExistDejaExeption;
import fr.isika.cda.galaxos.exceptions.RNAAssociationExistDejaExeption;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.FicheAssoCompta;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.model.FicheAssoGestionnaire;
import fr.isika.cda.galaxos.model.FicheAssociation;
import fr.isika.cda.galaxos.repository.AssociationRepository;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@Stateless
public class AssociationCompteService {

	@Inject
	private AssociationRepository associationRepository;

	public AssociationCompteService() {
	}

	public Association create(AssociationCreationForm associationCreationForm)
			throws NomAssociationExistDejaExeption, RNAAssociationExistDejaExeption {

		Optional<FicheAssociation> optionalNom = associationRepository.findByName(associationCreationForm.getNom());
		Optional<FicheAssociation> optionalRNA = associationRepository
				.findByRNA(associationCreationForm.getRnaNumber());

		if (optionalNom.isPresent()) {
			throw new NomAssociationExistDejaExeption("Le nom de cette association est déjà utilisé");
		}

		if (optionalRNA.isPresent()) {
			throw new RNAAssociationExistDejaExeption("Le numéro RNA de cette association est déjà utilisé");
		}

		return associationRepository.create(associationCreationForm);
	}

	public Association update(Association asso) {
		return associationRepository.update(asso);
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

	public Optional<Association> findById(Long id) {
		return associationRepository.findById(id);
	}
	
	public List<Association> findAll() {
		return associationRepository.findAll();
	}
}
