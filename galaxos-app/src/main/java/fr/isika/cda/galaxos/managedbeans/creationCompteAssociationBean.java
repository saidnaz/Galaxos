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
import fr.isika.cda.galaxos.model.Domaine;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.viewmodel.AssociationCreationForm;

@ManagedBean
@ViewScoped
public class creationCompteAssociationBean implements Serializable {

	private static final long serialVersionUID = 7915486897534594905L;

	@Inject
	private AssociationCompteService service;

	private AssociationCreationForm form = new AssociationCreationForm();
	
	private Long idAdherentConnecte;
	
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);	
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
	}


	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAssoForm");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		
		try {

			Association asso = service.create(form, idAdherentConnecte);

			session.setAttribute("assoId", asso.getId());
			
			
			return "finalisationCreationAssociation?faces-redirect=true";

		} catch (NomAssociationExistDejaExeption ex) {
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

	public Domaine[] getDomaines() {
		return Domaine.values();
	}

	public Long getIdAdherentConnecte() {
		return idAdherentConnecte;
	}

	public void setIdAdherentConnecte(Long idAdherentConnecte) {
		this.idAdherentConnecte = idAdherentConnecte;
	}

	
}
