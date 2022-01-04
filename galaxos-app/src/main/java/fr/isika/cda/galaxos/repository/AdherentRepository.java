package fr.isika.cda.galaxos.repository;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Consumer;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;
import fr.isika.cda.galaxos.viewmodel.ConsumerForm;

@Stateless
public class AdherentRepository implements Serializable{

	
	private static final long serialVersionUID = 4043566226541976881L;

	
	@PersistenceContext
	private EntityManager entityManager;
	public Adherent create(AdherentForm adherentForm) {
		
		Adherent adherent = new Adherent();

		adherent.setEmail(adherentForm.getEmail());
		adherent.setPassword(adherentForm.getPassword());
		
		entityManager.persist(adherent);
		
		return adherent;
	}
	
	public Optional<Adherent> findByEmail(String email) {
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Adherent.findByEmail", Adherent.class)
						.setParameter("email_param", email)
						.getSingleResult()
					);
		} catch(NoResultException ex) {
			System.out.println("Consumer.findByemail() - not found : " + email);
		}
		return Optional.empty();
	}

}
