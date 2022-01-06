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
import fr.isika.cda.galaxos.model.FicheAssoCompta;
import fr.isika.cda.galaxos.model.FicheAssoDescriptif;
import fr.isika.cda.galaxos.model.FicheAssoGestionnaire;
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

	private Double resultat;

	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {
			asso = optional.get();

			Double compteurCompta = 0.0;
			Double compteurGestionnaire = 0.0;
			Double compteurDescriptif = 0.0;

			if (asso.getFicheAssoCompta() != null) {
				compteurCompta = 1.0;
			}

			if (asso.getFicheAssoGestionnaire() != null) {
				compteurGestionnaire = 1.0;
			}

			if (asso.getFicheAssoDescriptif() != null) {
				compteurDescriptif = 1.0;
			}
			resultat= compteurCompta + compteurGestionnaire + compteurDescriptif + 2.0;			
			resultat = resultat/5;
			resultat = resultat*100;
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

			return "finalisationCreationAssociation";
		}
		return "";
	}

	public String creationGestionnaireAsso() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {

			Association asso = optional.get();
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
					.findComponent("createAssoGestionnaireForm");
			FicheAssoGestionnaire assoGestion = service.creationFicheAssoGestionnaire(form);
			asso.setFicheAssoGestionnaire(assoGestion);
			service.update(asso);
			return "finalisationCreationAssociation";
		}
		return "";
	}

	public String creationComptaAsso() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("assoId");

		Optional<Association> optional = service.findById(id);
		if (optional.isPresent()) {

			Association asso = optional.get();

			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot()
					.findComponent("createAssoComptaForm");
			FicheAssoCompta assoCompta = service.creationFicheAssoCompta(form);
			asso.setFicheAssoCompta(assoCompta);
			service.update(asso);
			return "finalisationCreationAssociation";
		}
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

	public Double getResultat() {
		return resultat;
	}

	public void setResultat(Double resultat) {
		this.resultat = resultat;
	}

}
