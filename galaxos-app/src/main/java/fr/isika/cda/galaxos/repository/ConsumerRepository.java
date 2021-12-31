package fr.isika.cda.galaxos.repository;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Consumer;
import fr.isika.cda.viewModel.ConsumerForm;



@Stateless
public class ConsumerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	public Consumer create(ConsumerForm consumerForm) {
		
		// On fait le mapping des attributs entre l'objet qui provient de la couche présentation
		// dans l'entité qu'on va persister
		Consumer consumerAccount = new Consumer();

		consumerAccount.setEmail(consumerForm.getEmail());
		consumerAccount.setPassword(consumerForm.getPassword());
		
		
		entityManager.persist(consumerAccount);
		
		// On renvoie l'objet persisté à jour (avec l'identifiant affecté par hibernate automatiquement)
		return consumerAccount;
	}
	
	
	
	public Optional<Consumer> findByIdConsumer(final Long idemail) {
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Consumer.findByIdConsumer", Consumer.class)
						.setParameter("idemail_param", idemail)
						.getSingleResult()
					);
		} catch(NoResultException ex) {
			System.out.println("Consumer.findByIdemail() - not found : " + idemail);
		}
		return Optional.empty();
	}

}
