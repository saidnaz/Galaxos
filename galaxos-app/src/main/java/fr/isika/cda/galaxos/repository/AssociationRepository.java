package fr.isika.cda.galaxos.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import fr.isika.cda.galaxos.helper.UploadHelper;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Association.Etat;
import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.Domaine;
import fr.isika.cda.galaxos.model.FicheAssoCompta;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.model.FicheAssoGestionnaire;
import fr.isika.cda.galaxos.model.FicheAssociation;
import fr.isika.cda.galaxos.model.roles.Consumer;
import fr.isika.cda.galaxos.model.roles.GestionnaireAssociation;
import fr.isika.cda.galaxos.model.roles.Provider;
import fr.isika.cda.galaxos.model.roles.Role;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@Stateless
public class AssociationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Association update(Association asso) {
		return entityManager.merge(asso);
	}

	public Association create(AssociationCreationForm form, Long id) {

		Association asso = new Association();
		FicheAssociation ficheAsso = new FicheAssociation();
		Domain domain = findOrCreateDomain(form.getDomaine());
		GestionnaireAssociation gestionnaireAssociation = new GestionnaireAssociation();
		Optional<Adherent> adherent = null;

		adherent = this.findAdherentById(id);
		if (adherent.isPresent()) {
			Adherent adhe = adherent.get();
			gestionnaireAssociation.setAdherent(adhe);
		}

		ficheAsso.setNom(form.getNom());
		ficheAsso.setRnaNumber(form.getRnaNumber());
		ficheAsso.setLocalisation(form.getLocalisation());
		ficheAsso.setEtat(fr.isika.cda.galaxos.model.FicheAssociation.Etat.EN_ATTENTE_VALIDATION);

		asso.setEtat(Etat.EN_COURS);
		asso.setFk_idDomain(domain);
		asso.setFicheAssociation(ficheAsso);

		gestionnaireAssociation.setAssociation(asso);

		entityManager.persist(domain);
		entityManager.persist(ficheAsso);
		entityManager.persist(asso);
		entityManager.persist(gestionnaireAssociation);

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

	public Optional<Domain> findDomaine(final Domaine name) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Domain.findDomaine", Domain.class)
					.setParameter("name", name).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("FIcheAssociation.findByName() - not found : " + name);
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

		String logo = "";
		Part part = form.getPart();

		UploadHelper uploadHelper = new UploadHelper();
		logo = uploadHelper.processUpload(part);

		assoDescriptif.setSlogan(form.getSlogan());
		assoDescriptif.setDescription(form.getDescription());
		assoDescriptif.setLogo(logo);
		assoDescriptif.setEtat(fr.isika.cda.galaxos.model.FicheAssoDescriptif.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoDescriptif);

		return assoDescriptif;
	}

	public FicheAssoGestionnaire creationFicheAssoGestionnaire(AssociationFinalisationForm form) {

		FicheAssoGestionnaire assoGestionnaire = new FicheAssoGestionnaire();

		String cni = "";
		Part part = form.getPieceIdentite();

		UploadHelper uploadHelper = new UploadHelper();
		cni = uploadHelper.processUpload(part);

		assoGestionnaire.setPieceIdentite(cni);
		assoGestionnaire.setEtat(fr.isika.cda.galaxos.model.FicheAssoGestionnaire.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoGestionnaire);

		return assoGestionnaire;
	}

	public FicheAssoCompta creationFicheAssoCompta(AssociationFinalisationForm form) {

		FicheAssoCompta assoCompta = new FicheAssoCompta();

		String rib = "";
		Part part = form.getRIB();

		UploadHelper uploadHelper = new UploadHelper();
		rib = uploadHelper.processUpload(part);

		assoCompta.setRib(rib);
		assoCompta.setCommission(form.getCommission());
		assoCompta.setEtat(fr.isika.cda.galaxos.model.FicheAssoCompta.Etat.EN_ATTENTE_DE_VALIDATION);

		entityManager.persist(assoCompta);

		return assoCompta;
	}

	private Domain findOrCreateDomain(Domaine nomDomaine) {
		Optional<Domain> optional = this.findDomaine(nomDomaine);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			Domain domain = new Domain();
			domain.setName(nomDomaine);
			return domain;
		}
	}

	public List<Association> findAll() {
		TypedQuery<Association> query = this.entityManager.createNamedQuery("Association.findAll", Association.class);
		List<Association> associations = query.getResultList();
		return associations;

	}

//	public List<Association> search(String localisation, String search, String domaine) {
//		List<Association> associations = null;
//		if (!localisation.equals("") && search.equals("") && domaine.equals("")) {
//			associations = entityManager
//					.createNativeQuery("SELECT * FROM Association " + "INNER JOIN Fiche_Association "
//							+ "WHERE Association.fk_ficheAssociation = Fiche_Association.id "
//							+ "AND Fiche_Association.localisation = :localisation", Association.class)
//					.setParameter("localisation", localisation).getResultList();
//		} else if (!localisation.equals("") && !search.equals("") && domaine == null) {
//			associations = entityManager.createNativeQuery(
//					"SELECT * FROM Association INNER JOIN Fiche_Association WHERE Association.fk_ficheAssociation = Fiche_Association.id AND Fiche_Association.localisation = :localisation AND Fiche_Association.nom = :search ",
//					Association.class).setParameter("localisation", localisation).setParameter("search", search)
//					.getResultList();
//		} else if (localisation.equals("") && !search.equals("") && domaine == null) {
//			associations = entityManager.createNativeQuery(
//					"SELECT * FROM Association INNER JOIN Fiche_Association WHERE Association.fk_ficheAssociation = Fiche_Association.id AND Fiche_Association.nom = :search ",
//					Association.class).setParameter("search", search).getResultList();
//		}
//		return associations;
//	}

	public List<Association> search(String localisation, String search, String domaine) {
		List<Association> associations = findAll();
		// if(search != null && !search.isEmpty())
		associations = this.findBySearch(search, associations);

		associations = this.findByLocalisation(localisation, associations);
		associations = this.findByCateg(domaine, associations);
		return associations;

	}

	public List<Association> findByCateg(String nomCateg) {
		List<Association> associations = null;
		if (!nomCateg.isBlank()) {
			associations = entityManager.createNativeQuery(
					"SELECT * FROM Association INNER JOIN Domain WHERE Association.fk_idDomain = Domain.idDomain AND Domain.NomDomaine = :nomCateg",
					Association.class).setParameter("nomCateg", nomCateg).getResultList();
		}
		return associations;
	}

	public List<Association> findByCateg(String nomCateg, List<Association> associations) {
		if (!nomCateg.equals("")) {
			return associations.stream().filter(asso -> asso.getFk_idDomain().getName().toString().equals(nomCateg))
					.collect(Collectors.toList());

//			associations = entityManager.createNativeQuery(
//					"SELECT * FROM Association INNER JOIN Domain WHERE Association.fk_idDomain = Domain.idDomain AND Domain.NomDomaine = :nomCateg",
//					Association.class).setParameter("nomCateg", nomCateg).getResultList();
		}
		return associations;
	}

	public List<Association> findBySearch(String search, List<Association> associations) {
		if (!search.equals("")) {
			return associations.stream().filter(asso -> asso.getFicheAssociation().getNom().equals(search))
					.collect(Collectors.toList());
//			associations = entityManager.createNativeQuery(
//					"SELECT * FROM Association INNER JOIN Fiche_Association WHERE Association.fk_ficheAssociation = Fiche_Association.id AND Fiche_Association.nom = :search ",
//					Association.class).setParameter("search", search).getResultList();
		}
		return associations;
	}

	public List<Association> findByLocalisation(String localisation, List<Association> associations) {
		if (!localisation.equals("")) {
			return associations.stream()
					.filter(asso -> asso.getFicheAssociation().getLocalisation().equals(localisation))
					.collect(Collectors.toList());

//			associations = entityManager
//					.createNativeQuery("SELECT * FROM Association " + "INNER JOIN Fiche_Association "
//							+ "WHERE Association.fk_ficheAssociation = Fiche_Association.id "
//							+ "AND Fiche_Association.localisation = :localisation", Association.class)
//					.setParameter("localisation", localisation).getResultList();
		}
		return associations;
	}

	public void delete(Association asso) {
		entityManager.remove(asso);
	}

	public Optional<Adherent> findAdherentById(Long id) {
		try {
			return Optional.ofNullable(this.entityManager.find(Adherent.class, id));
		} catch (NoResultException ex) {
			System.out.println("Consumer.findAdherentById() - not found : " + id);
		}
		return Optional.empty();
	}

	/*
	 * public Long findRoleParAdherent(Long idAdherentConnecte) { Object role =
	 * entityManager
	 * .createNativeQuery("SELECT id FROM Role	WHERE Role.adherent_id = :idAdherentConnecte"
	 * , Association.class) .setParameter("idAdherentConnecte",
	 * idAdherentConnecte).getSingleResult(); role = role.toString(); Long idRole =
	 * Long.parseLong(role); return idRole; }
	 */

	public List<Association> findAssociationsGestionnaireParAdherent(Long idAdherentConnecte) {
		List<Association> associations = null;

		return associations = entityManager.createNativeQuery(
				"SELECT * FROM Association INNER JOIN Client ON Client.association_id = Association.id INNER JOIN Role ON Client.id = Role.id INNER JOIN gestionnaires_assos ON Role.id = gestionnaires_assos.id WHERE Role.adherent_id = :idAdherentConnecte",
				Association.class).setParameter("idAdherentConnecte", idAdherentConnecte).getResultList();
	}

	public List<Association> findAssociationsProviderParAdherent(Long idAdherentConnecte) {
		List<Association> associations = null;

		return associations = entityManager.createNativeQuery(
				"SELECT * FROM Association INNER JOIN Client ON Client.association_id = Association.id INNER JOIN Role ON Client.id = Role.id INNER JOIN providers ON Role.id = providers.id WHERE Role.adherent_id = :idAdherentConnecte",
				Association.class).setParameter("idAdherentConnecte", idAdherentConnecte).getResultList();
	}

	public List<Association> findAssociationsAdherentParAdherent(Long idAdherentConnecte) {
		List<Association> associations = null;
		return associations = entityManager.createNativeQuery(
				"SELECT * FROM Association INNER JOIN Client ON Client.association_id = Association.id INNER JOIN Role ON Client.id = Role.id INNER JOIN consumers ON Role.id = consumers.id WHERE Role.adherent_id = :idAdherentConnecte",
				Association.class).setParameter("idAdherentConnecte", idAdherentConnecte).getResultList();

	}

	public List<Adherent> findProviderParAssociation(Long idAsso) {
		List<Adherent> adherents = null;

		return adherents = entityManager.createNativeQuery(
				"SELECT * FROM Adherent INNER JOIN Role ON Role.adherent_id = Adherent.id INNER JOIN Client ON Client.id = Role.id INNER JOIN Association ON Client.association_id = Association.id INNER JOIN providers ON Role.id = providers.id WHERE Association.id = :idAsso",
				Adherent.class).setParameter("idAsso", idAsso).getResultList();
	}

	// SELECT * FROM Adherent INNER JOIN Role ON Role.adherent_id = Adherent.id
	// INNER JOIN Client ON Client.id = Role.id INNER JOIN Association ON
	// Client.association_id = Association.id INNER JOIN providers ON Role.id =
	// providers.id WHERE Association.id = 24

	public Provider devenirProvider(Adherent adherent, Association asso) {
		Provider provider = new Provider();
		provider.setAdherent(adherent);
		provider.setAssociation(asso);
		provider.setNote(null);
		entityManager.persist(provider);
		return provider;
	}

	public Consumer devenirAdherent(Adherent adherentConnecte, Association asso) {
		Consumer consum = new Consumer();
		consum.setAdherent(adherentConnecte);
		consum.setAssociation(asso);
		entityManager.persist(consum);

		/*
		 * List<Role> roles = adherentConnecte.getRoles(); roles.add(consum);
		 * adherentConnecte.setRoles(roles); entityManager.merge(adherentConnecte);
		 */
		return consum;
	}

	public List<Adherent> findConsumerParAssociation(Long idAsso) {
		List<Adherent> adherents = null;

		return adherents = entityManager.createNativeQuery(
				"SELECT * FROM Adherent INNER JOIN Role ON Role.adherent_id = Adherent.id INNER JOIN Client ON Client.id = Role.id INNER JOIN Association ON Client.association_id = Association.id INNER JOIN consumers ON Role.id = consumers.id WHERE Association.id = :idAsso",
				Adherent.class).setParameter("idAsso", idAsso).getResultList();
	}

}
