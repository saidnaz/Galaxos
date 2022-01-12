package fr.isika.cda.galaxos.managedbeans;

import java.util.List;

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

	private String search;

	private Domaine domaines;

	public String afficherPageCatalogue() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String categName = req.getParameter("categName");
		if (categName.equals("all")) {
			associations = service.findAll();
		} else {
			associations = service.findByCateg(categName);
		}
		return "catalogueAsso";
	}

	public String search() {
		String domaine = (form.getDomaine() == null) ? "" : form.getDomaine().toString();
		System.out.println(domaine);
		if (localisation.equals("") && search.equals("") && domaine.equals("")) {
			associations = service.findAll();
		} else {
			associations = service.search(localisation, search, domaine);
		}
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setDomaines(Domaine domaines) {
		this.domaines = domaines;
	}

}
