package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@ManagedBean(name = "CreateAccountBean")
@SessionScoped
public class CreateAccountBean implements Serializable {

	private static final long serialVersionUID = 6612406132359512190L;

	@Inject
	private AdherentService accountService;

	private AdherentForm accountForm = new AdherentForm();

	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");
		
		// Si les mots de passe ne correspondent pas
		if( !accountForm.passwordsAreSame() ) {
		
		// ici utiliser le facescontext pour ajouter le message dynamiquement
		FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage("Les mots de passe ne correspondent pas"));
					
		// rester sur la même page (en gardant les infos du formulaire)
		return "";
		} else {
		
			try {
				// On appelle le service pour sauvegarder cet objet 
				// (qui a été rempli automatiquement depuis les champs de la page)
				Adherent adherent = accountService.create(accountForm);
				System.out.println("Adhérent créé : " + adherent);
				
				// On redirige vers le dashboard en cas de compte créé avec succès
				return "dashboardAdherent?faces-redirect=true";
				
				} catch (Exception ex) {
					// On ajoute un message sur la vue qui résume l'exception
					FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
				}
			
		// rester sur la même page en vidant les infos du formulaire (en cas d'erreur)	
		return "createAccount";
		}
	}

	public AdherentForm getAccountForm() {
		return accountForm;
	}
	public void setAccountForm(AdherentForm accountForm) {
		this.accountForm = accountForm;
	}

}
