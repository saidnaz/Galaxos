package fr.isika.cda.galaxos.service;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.repository.AdherentRepository;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;
import fr.isika.cda.galaxos.viewmodel.ProfilForm;

@Stateless
public class AdherentService {

	@Inject
	private AdherentRepository adherentRepository;
	
public AdherentService() {
	}
public Adherent create(AdherentForm adherentform) {
	

Optional<Adherent> optional = adherentRepository.findByEmail(adherentform.getEmail());//	

if( optional.isPresent() ) {
	throw new EntityNotFoundException("le compte adhérent existe déjà");
}

return adherentRepository.create(adherentform);
}

public Optional<Adherent> findByEmail(String email) {
	
	return adherentRepository.findByEmail(email);
}

public Optional<Adherent> findById(Long id) {
	
	return adherentRepository.findById(id);
}





	public Adherent updateAdherent(ProfilForm form) {
		return adherentRepository.updateAdherent(form);
	}
	
	public Profil updateProfil(Profil profil) {
		return adherentRepository.updateProfil(profil);
	}
	
	public CompteUser updateCptUser(CompteUser user) {
		return adherentRepository.updateCptUser(user);

	public Adherent update(Adherent adherent) {
		return adherentRepository.update(adherent);

	}
	
	public Optional<Adherent> findAdherentById(Long id) {
		return adherentRepository.findById(id);
	}
	
	public Optional<Profil> findProfilById(Long id) {
		return adherentRepository.findProfilById(id);
	}
	
	public Optional<CompteUser> findCptUserById(Long id) {
		return adherentRepository.findCptUserById(id);
	}


}
