package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;

@ManagedBean(name = "CreateAccountBean")
@ViewScoped
public class CreateAccountBean implements Serializable {

	private static final long serialVersionUID = 6612406132359512190L;

	@Inject
	private AdherentService accountService;

	private AdherentForm accountForm = new AdherentForm();

	@PostConstruct
	public void init()
	{
		AdherentForm adherent1 = new AdherentForm("simon.deb@gmail.com", "azer", "Debuire", "Simon", "Sim");
		AdherentForm ad2 = new AdherentForm("pierrefer@gmail.com", "azer", "Fernand", "Pierre", "PierreF");
		AdherentForm ad3 = new AdherentForm("manurolin@gmail.com", "azer", "Rolin", "Emmanuel", "Manu");
		AdherentForm ad4 = new AdherentForm("leadumont@outlook.fr", "azer", "Léa", "Dumont", "LéaD");
		accountService.create(adherent1);
		accountService.create(ad2);
		accountService.create(ad3);
		accountService.create(ad4);
		accountService.create(new AdherentForm("riridupuis@outlook.fr","azer","Richard","Dupuis","Riri" ));
	}
	
	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");
		try {
			Adherent adherent = accountService.create(accountForm);
			System.out.println("Adhérent créé : " + adherent);
			return "login?faces-redirect=true";
		} catch (Exception ex) {
			// On ajoute un message sur la vue qui résume l'exception
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
		}
		return "createAccount";
	}

	public AdherentForm getAccountForm() {
		return accountForm;
	}
	public void setAccountForm(AdherentForm accountForm) {
		this.accountForm = accountForm;
	}

}
