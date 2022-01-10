package fr.isika.cda.galaxos.service;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.repository.AdherentRepository;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@Stateless
public class AdherentService {

	@Inject
	private AdherentRepository adherentRepository;
	
	public AdherentService() {
	}

	public Adherent create(AdherentForm adherentform) {
		// je peux par exemple vérifier avant de persist si le user existe déjà
		Optional<Adherent> optional = adherentRepository.findByEmail(adherentform.getEmail());
		
		// User trouvé donc on lance une exception
		if (optional.isPresent()) {
			throw new EntityNotFoundException("le compte adhérent existe déjà");
		}
		
		// Utilisateur non trouvé -> donc email non utilisé
		// On crée alors le compte
		return adherentRepository.create(adherentform);
	}

	public Optional<Adherent> findByEmail(String email) {
		return adherentRepository.findByEmail(email);
	}

}
