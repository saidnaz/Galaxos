package fr.isika.cda.galaxos.repository;

import java.util.Optional;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.roles.Consumer;

@Stateless
public class PanierRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Optional<Panier> findByConsumer(Consumer con) {
		try {
//			return Query.createNamedQuery("Panier.findByConsumer", Panier.class)
//						.setParameter("consumer_param", con)
//						.getSingleResult()
//					);
		} catch(NoResultException ex) {
			System.out.println("Consumer.findByConsumer() - not found : " + con);
		}
		return Optional.empty();
	}

	public String findById(Adherent ad) {
		// TODO Auto-generated method stub
		return null;
	}

//	public static Optional<Adherent> findByIdPanier(Long id) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	

}
