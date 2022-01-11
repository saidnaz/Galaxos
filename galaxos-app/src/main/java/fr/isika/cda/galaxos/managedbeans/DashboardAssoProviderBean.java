package fr.isika.cda.galaxos.managedbeans;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.service.AssociationCompteService;

@ManagedBean
@ApplicationScoped
public class DashboardAssoProviderBean {

	@Inject
	private AssociationCompteService service;
	
	private Association asso = new Association();
	
	private List<Adherent> listAdherents;
	
	private Long idAdherentConnecte;
	
	private Adherent adherentConnecte = new Adherent();
	
	public String afficherListProviders(Long id) {
		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}
		listAdherents = service.findProviderParAssociation(asso.getId());
		return "dashboardAsso_providers";
	}
}
