package fr.isika.cda.galaxos.repository;

import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;

import fr.isika.cda.galaxos.helper.UploadHelper;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Association.Etat;
import fr.isika.cda.galaxos.model.FicheAssoCompta;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.model.FicheAssoGestionnaire;
import fr.isika.cda.galaxos.model.FicheAssociation;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@Stateless
public class AssociationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Association update(Association asso) {
		return entityManager.merge(asso);
	}

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

	public Optional<Association> findById(final Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Association.findById", Association.class)
					.setParameter("id", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Association.findById() - not found : " + id);
		}
		return Optional.empty();
	}

	public Optional<FicheAssociation> findByName(final String nom) {
		try {
			return Optional.ofNullable(
					this.entityManager.createNamedQuery("FicheAssociation.findByName", FicheAssociation.class)
							.setParameter("nom", nom).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("FIcheAssociation.findByName() - not found : " + nom);
		}
		return Optional.empty();
	}

	public Optional<FicheAssociation> findByRNA(final String rnaNumber) {
		try {
			return Optional.ofNullable(
					this.entityManager.createNamedQuery("FicheAssociation.findByRNA", FicheAssociation.class)
							.setParameter("rnaNumber", rnaNumber).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("FIcheAssociation.findByRNA() - not found : " + rnaNumber);
		}
		return Optional.empty();
	}

	public FicheAssoDescriptif creationFicheAssoDescriptif(AssociationFinalisationForm form) {

		FicheAssoDescriptif assoDescriptif = new FicheAssoDescriptif();

		String photo = "";
		Part part = form.getPart();

		UploadHelper uploadHelper = new UploadHelper();
		photo = uploadHelper.processUpload(part);

		assoDescriptif.setSlogan(form.getSlogan());
		assoDescriptif.setDescription(form.getDescription());
		assoDescriptif.setLogo(photo);
		assoDescriptif.setEtat(fr.isika.cda.galaxos.model.FicheAssoDescriptif.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoDescriptif);

		return assoDescriptif;
	}

	public FicheAssoGestionnaire creationFicheAssoGestionnaire(AssociationFinalisationForm form) {

		FicheAssoGestionnaire assoGestionnaire = new FicheAssoGestionnaire();

		assoGestionnaire.setPieceIdentite(form.getPieceIdentite());
		assoGestionnaire.setEtat(fr.isika.cda.galaxos.model.FicheAssoGestionnaire.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoGestionnaire);

		return assoGestionnaire;
	}

	public FicheAssoCompta creationFicheAssoCompta(AssociationFinalisationForm form) {

		FicheAssoCompta assoCompta = new FicheAssoCompta();

		assoCompta.setRIB(form.getRIB());
		assoCompta.setCommission(form.getCommission());
		assoCompta.setEtat(fr.isika.cda.galaxos.model.FicheAssoCompta.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoCompta);

		return assoCompta;
	}
}
