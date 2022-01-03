package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;

@ManagedBean
@ViewScoped
public class creationCompteAssociationBean implements Serializable {

	private static final long serialVersionUID = 7915486897534594905L;

	@Inject
	private AssociationCompteService service;

	private AssociationCreationForm form = new AssociationCreationForm();;

	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAssoForm");
		service.create(form);
		return "index?faces-redirect=true";
	}

	// GETTERS ET SETTERS
	public AssociationCompteService getService() {
		return service;
	}

	public void setService(AssociationCompteService service) {
		this.service = service;
	}

	public AssociationCreationForm getForm() {
		return form;
	}

	public void setForm(AssociationCreationForm form) {
		this.form = form;
	}

}
