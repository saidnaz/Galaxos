package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.exceptions.NomAssociationExistDejaExeption;
import fr.isika.cda.galaxos.exceptions.RNAAssociationExistDejaExeption;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;

@ManagedBean
@ViewScoped
public class creationCompteAssociationBean implements Serializable {

	private static final long serialVersionUID = 7915486897534594905L;

	@Inject
	private AssociationCompteService service;

	private AssociationCreationForm form = new AssociationCreationForm();

	public String create() {

		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAssoForm");
		//UIComponent inputNom = FacesContext.getCurrentInstance().getViewRoot().findComponent("nomAssoInput");

		try {
			Association asso = service.create(form);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("assoId", asso.getId());

			return "finalisationCreationAssociation?faces-redirect=true";

		} catch (NomAssociationExistDejaExeption ex) {

			//FacesContext.getCurrentInstance().addMessage(inputNom.getClientId(), new FacesMessage(ex.getMessage()));
			//FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
			FacesContext.getCurrentInstance().addMessage("forumaire:nomAssoInput", new FacesMessage(ex.getMessage()));
			System.out.println("NOM DEJA EN BASE");
		} catch (RNAAssociationExistDejaExeption ex) {
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
			System.out.println("RNA DEJA EN BASE ne pas persist");
		}
		return "creationAssociation";
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
