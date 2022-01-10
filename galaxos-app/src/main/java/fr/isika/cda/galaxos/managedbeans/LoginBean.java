package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.repository.Cryptage;
import fr.isika.cda.galaxos.service.AdherentService;
@ManagedBean
public class LoginBean implements Serializable {
	
	
	private static final long serialVersionUID = -182763123620809611L;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Email
	private String email;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	private String password;
	private String connectedAdherent = "";
	
	@Inject
	private AdherentService adherentService;
	
	public String doLogin () {
		Optional<Adherent> optional = adherentService.findByEmail(email);
		if (optional.isPresent()) {
			
			Adherent adherent = optional.get();
			String passwordCrypt = Cryptage.encryptPassword(password);
			
			if (adherent.getUser().getMdp().equals(passwordCrypt)) {
				
				// Email ISVALID and Password ISVALID
				connectedAdherent = adherent.getUser().getEmail();
				
				// On va l'écrire dans la sesssion Http
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("connectedAdherentId", adherent.getId());
				session.setAttribute("connectedAdherent", adherent);
				session.setAttribute("profil", adherent.getProfil());
				
				return "dashboardAdherent?faces-redirect=true";
			} else {

				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
						new FacesMessage("Identifiants incorrects"));
			}
		} else {
			
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
					new FacesMessage("Adhérent non reconnu"));
		}
		return "login";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String getConnectedAdherent() {
		return connectedAdherent;
	}
	public void setConnectedAdherent(String connectedAdherent) {
		this.connectedAdherent = connectedAdherent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


}
