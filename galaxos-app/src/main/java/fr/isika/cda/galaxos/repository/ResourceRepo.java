package fr.isika.cda.galaxos.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.*;

import fr.isika.cda.galaxos.dto.LocationAddForm;
import fr.isika.cda.galaxos.dto.ResourceAddForm;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.resources.Location;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.model.resources.Vente;
import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;
import fr.isika.cda.galaxos.model.resources.reservations.Reservation;
import fr.isika.cda.galaxos.model.roles.Provider;

@Stateless
public class ResourceRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Resource create(ResourceAddForm form) {
		
		Resource resource;
		String type = form.getClass().getName();
		System.out.println("LE TYPE EST : " + type);
		if(type.equals("fr.isika.cda.galaxos.dto.VenteAddForm")) {
			resource = new Vente();
			((Vente) resource).setDispo(true);
		}
		else if(type.equals("fr.isika.cda.galaxos.dto.LocationAddForm")) {
			resource = new Location();
			GestionnaireResa gestRes = new GestionnaireResa();
		
			LocalDateTime debut = ((LocationAddForm)form).getDateDebut();
			if(debut != null) {
				Reservation reservation = new Reservation();
				reservation.setDateFin(((LocationAddForm)form).getDateFin());
				gestRes.addFkReservation(reservation);
			}
			((Location) resource).setGestResa(gestRes);
			entityManager.persist(gestRes);
		}
		else {
			resource = null;
		}
		
		resource.setName(form.getName());
		double prix= Double.parseDouble(form.getTarif());
		resource.setTarif(prix);
		resource.setProvider(form.getProvider());
        resource.setDatePublication(form.getDate());
		resource.setAssociation(form.getAssociation());
		resource.setDescription(form.getDescription());
		System.out.println(resource.toString());
		
		entityManager.persist(resource);
		
		return resource;
	}
	
	public List<Resource> findAll() {
		TypedQuery<Resource> query = this.entityManager.createNamedQuery("Resource.findAll", Resource.class);
		List<Resource> resources = query.getResultList();
		return resources;
	}
	
	public Optional<Resource> findById(final Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Resource.findById", Resource.class)
					.setParameter("id", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Resource.findById() - not found : " + id);
		}
		return Optional.empty();
	}
	
	public List<Resource> findByAssociation(Long idAsso) {
		System.out.println("i'm in the repo!!" + idAsso);
		List<Resource> resources = entityManager.createNativeQuery("SELECT * FROM Resource INNER JOIN providers ON providers.id = Resource.provider_id INNER JOIN Client ON Client.id = providers.id INNER JOIN Association ON Association.id = Client.association_id WHERE Association.id = :idAsso", Resource.class).setParameter("idAsso", idAsso).getResultList();
		if(resources.size() != 0)System.out.println("Hello repo" + resources.get(0).getIdRessource());
		else System.out.println("Non ya person!");
		return resources;
	}
	
	public List<Provider> findProviderByAdh(Long idAdh) {
		System.out.println(idAdh);
		List<Provider>	providers = entityManager.createNativeQuery("SELECT * FROM providers INNER JOIN Client ON Client.id = providers.id INNER JOIN Role ON Role.id = Client.id INNER JOIN Adherent ON Adherent.id = Role.adherent_id WHERE Adherent.id = :idAdh", Provider.class).setParameter("idAdh", idAdh).getResultList();
			if(providers.size() != 0)System.out.println(providers.get(0).getId());
			else System.out.println("Non ya person!");
			return providers;
	}
	
	public List<Association> findAssociationsAdherentParAdherent(Long idAdherentConnecte) {
		List<Association> associations = null;
		return associations = entityManager.createNativeQuery(
				"SELECT * FROM Association INNER JOIN Client ON Client.association_id = Association.id INNER JOIN Role ON Client.id = Role.id WHERE Role.adherent_id = :idAdherentConnecte",
				Association.class).setParameter("idAdherentConnecte", idAdherentConnecte).getResultList();

	}
		
}
