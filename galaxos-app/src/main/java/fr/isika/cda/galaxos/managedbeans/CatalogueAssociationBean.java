package fr.isika.cda.galaxos.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Domaine;
import fr.isika.cda.galaxos.repository.AssociationRepository;
import fr.isika.cda.galaxos.viewmodel.CatalogueAssoForm;

@ManagedBean(name = "CatalogueAssociationBean")
@RequestScoped
public class CatalogueAssociationBean {

	@Inject
	private AssociationRepository service;

	private CatalogueAssoForm form = new CatalogueAssoForm();

	private List<Association> associations;
	
	private String localisation;



	@PostConstruct
	public void init() {
		associations = service.findAll();
	}

	public String search() {
		//HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//String localisation = request.getParameter("localisation");
		associations = service.search(localisation);
		return "catalogueAsso";
	}

	public AssociationRepository getService() {
		return service;
	}

	public void setService(AssociationRepository service) {
		this.service = service;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

	public CatalogueAssoForm getForm() {
		return form;
	}

	public void setForm(CatalogueAssoForm form) {
		this.form = form;
	}

	public Domaine[] getDomaines() {
		return Domaine.values();
	}
	
	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

}
