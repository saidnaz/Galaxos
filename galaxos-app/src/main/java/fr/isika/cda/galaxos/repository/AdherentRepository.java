package fr.isika.cda.galaxos.repository;

import java.io.Serializable;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@Stateless
public class AdherentRepository implements Serializable{

	private static final long serialVersionUID = 4043566226541976881L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Adherent create(AdherentForm adherentForm) {
		// On fait le mapping des attributs entre l'objet qui provient de la couche présentation
		// dans l'entité qu'on va persister
		Adherent adherent = new Adherent();
		CompteUser cptUser = new CompteUser();
		Profil profil = new Profil();
		
		String passwordCrypt = Cryptage.encryptPassword(adherentForm.getPassword());
		
		cptUser.setMdp(passwordCrypt);
		cptUser.setEmail(adherentForm.getEmail());
		
//		profil.setPseudo(adherentForm.getPseudo());
		profil.setPrenom(adherentForm.getPrenom());
		profil.setNom(adherentForm.getNom());
		
		adherent.setUser(cptUser);
		adherent.setProfil(profil);
		
		// On persiste l'objet 
		entityManager.persist(adherent);
		
		// On renvoie l'objet persisté à jour (avec l'identifiant affecté par hibernate automatiquement)
		return adherent;
	}
	
	public Optional<Adherent> findByEmail(String email) {
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Adherent.findByEmail", Adherent.class)
						.setParameter("email_param", email)
						.getSingleResult());
		} catch(NoResultException ex) {
			System.out.println("Consumer.findByemail() - not found : " + email);
		}
		return Optional.empty();
	}
	
	

}
