package fr.isika.cda.galaxos.repository;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.roles.Consumer;
import fr.isika.cda.galaxos.viewmodel.ConsumerForm;

@Stateless
public class ConsumerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	public Consumer create(ConsumerForm consumerForm) {
		
		Consumer consumer = new Consumer();

//		consumer.setEmail(consumerForm.getEmail());
//		consumer.setPassword(consumerForm.getPassword());
		
		entityManager.persist(consumer);
		
		return consumer;
	}
	public Optional<Consumer> findByEmail(String email) {
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Consumer.findByEmail", Consumer.class)
						.setParameter("email_param", email)
						.getSingleResult()
					);
		} catch(NoResultException ex) {
			System.out.println("Consumer.findByemail() - not found : " + email);
		}
		return Optional.empty();
	}

	

	public Consumer findByIdConsumer(Long idUser) {
		Consumer consumer = new Consumer();
		
		return null;
	}

}
