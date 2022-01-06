package fr.isika.cda.galaxos.service;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import fr.isika.cda.galaxos.model.roles.Consumer;
import fr.isika.cda.galaxos.repository.ConsumerRepository;
import fr.isika.cda.galaxos.viewmodel.ConsumerForm;

@Stateless
public class ConsumerService {

	@Inject
	private ConsumerRepository consumerRepository;

	public ConsumerService() {
	}

	public Consumer create(ConsumerForm consumerform) {

		Optional<Consumer> optional = consumerRepository.findByEmail(consumerform.getEmail());//
		// user trouvé donc on lance une exception
		if (optional.isPresent()) {
			throw new EntityNotFoundException("le compte consumer existe déjà");
		}

//	// utilisateur non trouvé -> donc email non utilisé
		// on crée alors un compte
		return consumerRepository.create(consumerform);
	}

	public Optional<Consumer> findByEmail(String email) {
		return consumerRepository.findByEmail(email);
	}

}
