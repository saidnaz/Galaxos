package fr.isika.cda.galaxos.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Facture;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.roles.Consumer;



@Stateless
public class FactureRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Facture findMyFacture(Panier panierId) {
		return null;
		
	}
	
	public List<Facture> getAllMyFactures(Consumer consumerId){
		
	
	return null;
	
	
	}
	
	
	
	}

