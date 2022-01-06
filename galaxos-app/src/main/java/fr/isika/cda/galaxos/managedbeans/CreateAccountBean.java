package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@ManagedBean(name="CreateAccountBean")
@ViewScoped
public class CreateAccountBean implements Serializable {

	private static final long serialVersionUID = 6612406132359512190L;

	public CreateAccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private AdherentService accountService;
	
	private AdherentForm accountForm = new AdherentForm();
	
	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");
		
		// Si les mots de passe et email sont vides
		if( accountForm.equals(null)){
		
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(" Remplir le mot de passe et l'email"));
			
			
			return "";
		} else {
			try {

				accountService.create(accountForm);
				
				
				return "loginSuccess?faces-redirect=true";
				
			} catch(Exception ex) {
				// On ajoute un message sur la vue qui résume l'exception
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
			}
			
			
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
