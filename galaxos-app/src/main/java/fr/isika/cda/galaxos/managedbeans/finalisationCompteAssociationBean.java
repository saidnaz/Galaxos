package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.AssociationFinalisationForm;

@ManagedBean
@ViewScoped
public class finalisationCompteAssociationBean implements Serializable {

	private static final long serialVersionUID = 6996941272696131543L;

	/* private EntityManager entityManager; */

	@Inject
	private AssociationCompteService service;

	private AssociationFinalisationForm form = new AssociationFinalisationForm();
	
	private Association asso;


	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();
		}

	}

	public String creationDescriptifAsso() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {

			Association asso = optional.get();

			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
					.findComponent("createAssoDescriptifForm");
			FicheAssoDescriptif assoDescri = service.creationFicheAssoDescriptif(form);
			asso.setFicheAssoDescriptif(assoDescri);
			service.update(asso);
			/* entityManager.merge(asso); */
			return "finalisationCreationAssociation";
		}
		return "";
	}

	public String creationGestionnaireAsso() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
				.findComponent("createAssoGestionnaireForm");
		service.creationFicheAssoGestionnaire(form);
		return "finalisationCreationAssociation";
	}

	public String creationComptaAsso() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAssoComptaForm");
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

	public Association getAsso() {
		return asso;
	}
	public void setAsso(Association asso) {
		this.asso = asso;
	}
}
