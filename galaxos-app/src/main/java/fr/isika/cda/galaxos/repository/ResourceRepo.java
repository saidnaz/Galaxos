package fr.isika.cda.galaxos.repository;

import javax.ejb.Stateless;
import javax.persistence.*;

import fr.isika.cda.galaxos.dto.ResourceAddForm;
import fr.isika.cda.galaxos.model.resources.Location;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.model.resources.Vente;
import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;

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
			((Location) resource).setGestResa(gestRes);
			entityManager.persist(gestRes);
		}
		else {
			resource = null;
		}
		
		resource.setName(form.getName());
		double prix= Double.parseDouble(form.getTarif());
		resource.setTarif(prix);
		
		System.out.println(resource.toString());
		
		entityManager.persist(resource);
		
		return resource;
	}
}
