package fr.isika.cda.galaxos.managedbeans;

import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.CatalogueAssoForm;

@ManagedBean
@RequestScoped
public class AssociationBean {

	@Inject
	private AssociationCompteService service;

	private Association asso = new Association();

	public String init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String idString = request.getParameter("id");
		Long id = Long.valueOf(idString);
		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}
		return "association";

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

}
