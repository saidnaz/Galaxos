package fr.isika.cda.galaxos.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.dto.LocationAddForm;
import fr.isika.cda.galaxos.dto.ResourceAddForm;
import fr.isika.cda.galaxos.model.resources.Location;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.model.resources.Vente;
import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;
import fr.isika.cda.galaxos.model.resources.reservations.Reservation;

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
		
		//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		//Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		resource.setProvider(null);
        resource.setDatePublication(LocalDateTime.now());
		
		System.out.println(resource.toString());
		
		entityManager.persist(resource);
		
		return resource;
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
}
