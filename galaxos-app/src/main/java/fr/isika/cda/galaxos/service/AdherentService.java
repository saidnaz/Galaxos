package fr.isika.cda.galaxos.service;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.repository.AdherentRepository;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@Stateless
public class AdherentService implements Serializable{
	
	@Inject
	private AdherentRepository adherentRepository;



public AdherentService() {
	super();
	
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






}
