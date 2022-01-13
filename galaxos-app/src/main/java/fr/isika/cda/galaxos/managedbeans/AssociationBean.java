package fr.isika.cda.galaxos.managedbeans;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.service.AssociationCompteService;

@ManagedBean
@ViewScoped
public class AssociationBean {

	@Inject
	private AssociationCompteService service;

	private Association asso = new Association();

	private Adherent adherentConnecte = new Adherent();

	private List<Association> associations;

	private List<Adherent> listAdherents;
	private List<Adherent> listProviders;

	private Long idAdherentConnecte;

	private Boolean isAdherent;
	private Boolean isProvider;

	/*
	 * public String init() { HttpServletRequest request = (HttpServletRequest)
	 * FacesContext.getCurrentInstance().getExternalContext() .getRequest(); String
	 * idString = request.getParameter("id"); Long id = Long.valueOf(idString);
	 * Optional<Association> optional = service.findById(id); if
	 * (optional.isPresent()) { asso = optional.get(); } return "association"; }
	 */

	@PostConstruct
	public void init() {

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String idString = params.get("idAsso");
		Long idAsso = Long.parseLong(idString);

		// on chercher l'asso en question
		Optional<Association> optional = service.findById(idAsso);
		if (optional.isPresent()) {
			asso = optional.get();
		}

		// on recupere l'adherent connecté
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
		if (optionalAd.isPresent()) {
			adherentConnecte = optionalAd.get();
		}

		// on recupere la liste des adherents pour voir si oui ou non l'adheerent en
		// fait parti
		listAdherents = service.findConsumerParAssociation(asso.getId());
		isAdherent = false;
		if (listAdherents.contains(adherentConnecte)) {
			isAdherent = true;
		}

		// on recupere la liste des providers pour voir si oui ou non l'adheerent en
		// fait parti
		listProviders = service.findProviderParAssociation(asso.getId());
		isProvider = false;
		if (listProviders.contains(adherentConnecte)) {
			isProvider = true;
		}

		//return "association";
	}

	public String devenirProvider(Association asso) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
		if (optionalAd.isPresent()) {
			adherentConnecte = optionalAd.get();
			service.devenirProvider(adherentConnecte, asso);
			return "dashboardAdherent_profile";
		}
		return "login";
	}

	public String devenirAdherent(Association asso) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
		if (optionalAd.isPresent()) {
			adherentConnecte = optionalAd.get();
			service.devenirAdherent(adherentConnecte, asso);
			return "dashboardAdherent_profile";
		}
		return "login";
	}

	public String delete(Long id) {
		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
			service.delete(asso);
		}
		return "index";
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

	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

	public Long getIdAdherentConnecte() {
		return idAdherentConnecte;
	}

	public void setIdAdherentConnecte(Long idAdherentConnecte) {
		this.idAdherentConnecte = idAdherentConnecte;
	}

	public List<Adherent> getListAdherents() {
		return listAdherents;
	}

	public void setListAdherents(List<Adherent> listAdherents) {
		this.listAdherents = listAdherents;
	}

	public Boolean getIsAdherent() {
		return isAdherent;
	}

	public void setIsAdherent(Boolean isAdherent) {
		this.isAdherent = isAdherent;
	}

	public Boolean getIsProvider() {
		return isProvider;
	}

	public void setIsProvider(Boolean isProvider) {
		this.isProvider = isProvider;
	}

	public List<Adherent> getListProviders() {
		return listProviders;
	}

	public void setListProviders(List<Adherent> listProviders) {
		this.listProviders = listProviders;
	}

}
