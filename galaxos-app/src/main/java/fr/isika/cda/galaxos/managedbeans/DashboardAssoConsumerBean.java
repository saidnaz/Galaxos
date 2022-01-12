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
public class DashboardAssoConsumerBean {

	@Inject
	private AssociationCompteService service;

	private Association asso = new Association();

	private List<Adherent> listAdherents;

	private Long idAdherentConnecte;

	private Adherent adherentConnecte = new Adherent();

	public String afficherListConsumers(Long id) {
		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}
		listAdherents = service.findConsumerParAssociation(asso.getId());
		return "dashboardAsso_consumer";
	}

	public AssociationCompteService getService() {
		return service;
	}

	public void setService(AssociationCompteService service) {
		this.service = service;
	}

	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}

	public List<Adherent> getListAdherents() {
		return listAdherents;
	}

	public void setListAdherents(List<Adherent> listAdherents) {
		this.listAdherents = listAdherents;
	}

	public Long getIdAdherentConnecte() {
		return idAdherentConnecte;
	}

	public void setIdAdherentConnecte(Long idAdherentConnecte) {
		this.idAdherentConnecte = idAdherentConnecte;
	}

	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}

}
