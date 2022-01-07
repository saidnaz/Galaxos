package fr.isika.cda.galaxos.repository;

import javax.ejb.Stateless;
import javax.persistence.*;

import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.viewmodel.ResourceAddForm;

@Stateless
public class RessourceRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Resource create(ResourceAddForm form) {
		
		Resource resource = null;
		return resource;
	}

}

/*
 * @Stateless
public class AssociationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Association create(AssociationCreationForm form) {

		Association asso = new Association();
		FicheAssociation ficheAsso = new FicheAssociation();

		ficheAsso.setNom(form.getNom());
		ficheAsso.setRnaNumber(form.getRnaNumber());
		ficheAsso.setLocalisation(form.getLocalisation());
		ficheAsso.setEtat(fr.isika.cda.galaxos.model.FicheAssociation.Etat.EN_ATTENTE_VALIDATION);

		asso.setEtat(Etat.EN_COURS);
		asso.setFk_idDomain(null);
		asso.setFicheAssociation(ficheAsso);

		entityManager.persist(ficheAsso);
		entityManager.persist(asso);

		return asso;
	}
}
 */
