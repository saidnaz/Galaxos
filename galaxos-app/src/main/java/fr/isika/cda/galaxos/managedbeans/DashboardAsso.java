package fr.isika.cda.galaxos.managedbeans;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.service.AssociationCompteService;

@ManagedBean
@ViewScoped
public class DashboardAsso {

	@Inject
	private AssociationCompteService service;

	Association asso = new Association();

	private Adherent adherentConnecte;

	private List<Adherent> listProviders;

	private List<Adherent> listConsumers;

	int countProviders;
	int countConsumers;

	@PostConstruct
	public void init() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");

		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
		if (optionalAd.isPresent()) {
			adherentConnecte = optionalAd.get();
		}

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}

		listProviders = service.findProviderParAssociation(asso.getId());
		countProviders = listProviders.size();
		
		listConsumers = service.findConsumerParAssociation(asso.getId());
		countConsumers = listConsumers.size();

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

	public DashboardAsso() {
		// TODO Auto-generated constructor stub
	}

	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}

	public List<Adherent> getListProviders() {
		return listProviders;
	}

	public void setListProviders(List<Adherent> listProviders) {
		this.listProviders = listProviders;
	}

	public int getCountProviders() {
		return countProviders;
	}

	public void setCountProviders(int countProviders) {
		this.countProviders = countProviders;
	}

	public List<Adherent> getListConsumers() {
		return listConsumers;
	}

	public void setListConsumers(List<Adherent> listConsumers) {
		this.listConsumers = listConsumers;
	}

	public int getCountConsumers() {
		return countConsumers;
	}

	public void setCountConsumers(int countConsumers) {
		this.countConsumers = countConsumers;
	}

}
