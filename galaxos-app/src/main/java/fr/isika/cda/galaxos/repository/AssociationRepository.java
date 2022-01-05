package fr.isika.cda.galaxos.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Association.Etat;
import fr.isika.cda.galaxos.model.FicheAssociation;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;

@Stateless
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
