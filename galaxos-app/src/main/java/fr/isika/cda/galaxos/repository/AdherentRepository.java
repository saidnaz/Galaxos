package fr.isika.cda.galaxos.repository;

import java.io.Serializable;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Adresse;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;
import fr.isika.cda.galaxos.viewmodel.ProfilForm;

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
//		Adresse adresse = new Adresse("", "", 0, "");
//		Profil profil = new Profil("", "", "", "", adresse);
		Adresse adresse = new Adresse();
		Profil profil = new Profil();
		
		String passwordCrypt = Cryptage.encryptPassword(adherentForm.getPassword());
		
		cptUser.setMdp(passwordCrypt);
		cptUser.setEmail(adherentForm.getEmail());
		
//		profil.setPseudo(adherentForm.getPseudo());
		profil.setPrenom(adherentForm.getPrenom());
		profil.setNom(adherentForm.getNom());
		
		adherent.setUser(cptUser);
		adherent.setProfil(profil);
		adherent.setRole(adherentForm.getRole());
		
		
	//	adherent.setRoles(adherentForm.getRoles());
		
		
		// On persiste l'objet 
		entityManager.persist(adherent);
		
		// On renvoie l'objet persisté à jour (avec l'identifiant affecté par hibernate automatiquement)
		return adherent;
	}
	
	public Profil updateProfil(Profil profil) {
		return entityManager.merge(profil);
	}
	
	public CompteUser updateCptUser(CompteUser user) {
		return entityManager.merge(user);
	}
	
	public Adherent updateAdherent(ProfilForm form) {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Adherent adherent = (Adherent) session.getAttribute("connectedAdherent");
		
		Profil profil = adherent.getProfil();
		Adresse adresse = profil.getAdresse();
		
		adresse.setNumero(form.getNumero());
		adresse.setLibelle(form.getLibelle());
		adresse.setCodePostal(form.getCodePostal());
		adresse.setVille(form.getVille());
		
//		profil.setNom(form.getNom());
//		profil.setPrenom(form.getPrenom());
		profil.setTelephone(form.getTelephone());
		profil.setDescription(form.getDescription());
		profil.setAdresse(adresse);
		
		adherent.setProfil(profil);
		
		entityManager.merge(adherent);
		return adherent;
	}
	
	public Optional<Adherent> findById(final Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Adherent.findById", Adherent.class)
					.setParameter("id", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Adherent.findById() - not found : " + id);
		}
		return Optional.empty();
	}
	
	public Optional<Adherent> findByEmail(String email) {
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Adherent.findByEmail", Adherent.class)
						.setParameter("email_param", email)
						.getSingleResult());
		} catch(NoResultException ex) {
			System.out.println("Adherent.findByemail() - not found : " + email);
		}
		return Optional.empty();
	}
	
	public Optional<Profil> findProfilById(final Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Profil.findById", Profil.class)
					.setParameter("id", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Profil.findById() - not found : " + id);
		}
		return Optional.empty();
	}
	
	public Optional<CompteUser> findCptUserById(final Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("CompteUser.findById", CompteUser.class)
					.setParameter("id", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("CompteUser.findById() - not found : " + id);
		}
		return Optional.empty();
	}
	

}
