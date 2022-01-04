package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.service.ConsumerService;
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
			if (adherent.getEmail().equals(email) && adherent.getPassword().equals(password)) {
				
				// Si même email et mot de passe -> On redirige vers une autre page
				connectedAdherent = adherent.getEmail();
				return "index";
			} else {

				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("consumerForm");
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
						new FacesMessage("Identifiants incorrects"));
			}
		} else {
			
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("AdherentForm");
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
					new FacesMessage("Adhérent non reconnu"));
		}

		
		return "adherent";
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

	public String getConnectedConsumer() {
		return connectedAdherent;
	}

	public void setConnectedConsumer(String connectedConsumer) {
		this.connectedAdherent = connectedAdherent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


}
