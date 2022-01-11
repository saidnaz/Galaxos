package fr.isika.cda.galaxos.managedbeans;

import java.util.List;
import java.util.Optional;

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
@ApplicationScoped
public class AssociationBean {

	@Inject
	private AssociationCompteService service;

	private Association asso = new Association();
	
	private Adherent adherentConnecte = new Adherent();
	
	private List<Association> associations;
	
	private List<Adherent> listAdherents;
	
	private Long idAdherentConnecte;


	/*
	 * public String init() { HttpServletRequest request = (HttpServletRequest)
	 * FacesContext.getCurrentInstance().getExternalContext() .getRequest(); String
	 * idString = request.getParameter("id"); Long id = Long.valueOf(idString);
	 * Optional<Association> optional = service.findById(id); if
	 * (optional.isPresent()) { asso = optional.get(); } return "association"; }
	 */
	
	public String affichageAsso(Long id) {
		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}
		listAdherents = service.findProviderParAssociation(asso.getId());
		return "association";
	}
	
	public String devenirProvider(Association asso) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);	
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
		if(optionalAd.isPresent()) {
			adherentConnecte = optionalAd.get();
			service.devenirProvider(adherentConnecte, asso);
			return "index";
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


}
