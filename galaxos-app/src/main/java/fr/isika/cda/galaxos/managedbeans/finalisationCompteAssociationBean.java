package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@ManagedBean
@ViewScoped
public class finalisationCompteAssociationBean implements Serializable {

	private static final long serialVersionUID = 6996941272696131543L;

	@Inject
	private AssociationCompteService service;

	private AssociationFinalisationForm form = new AssociationFinalisationForm();

	public String creationDescriptifAsso() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
				.findComponent("createAssoDescriptifForm");
		service.creationFicheAssoDescriptif(form);
		return "";
	}

	public String creationGestionnaireAsso() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
				.findComponent("createAssoGestionnaireForm");
		service.creationFicheAssoGestionnaire(form);
		return "";
	}
	
	public String creationComptaAsso() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
				.findComponent("createAssoComptaForm");
		service.creationFicheAssoCompta(form);
		return "";
	}

	public AssociationCompteService getService() {
		return service;
	}

	public void setService(AssociationCompteService service) {
		this.service = service;
	}

	public AssociationFinalisationForm getForm() {
		return form;
	}

	public void setForm(AssociationFinalisationForm form) {
		this.form = form;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public finalisationCompteAssociationBean() {
		super();
	}
	
	

}
