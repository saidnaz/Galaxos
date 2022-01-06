package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.service.ConsumerService;

@ManagedBean(name="ConsumerBean")

public class ConsumerBean implements Serializable {

	private static final long serialVersionUID = -3442641433704975390L;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Email
	private String email;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	private String password;
	private String connectedConsumer = "";
	
	@Inject
	private ConsumerService consumerService;
	
	public String doConsumer () {
		
		// On va lire dans la sesssion Http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long adherentId = Long.valueOf((String) session.getAttribute("connectedAdherentId"));
		
		// TODO find adherent by id
		
//		Optional<Consumer> optional = consumerService.findByEmail(email);

//		if (optional.isPresent()) {
//			
//			Consumer consumer = optional.get();
//			if (consumer.getEmail().equals(email) && consumer.getPassword().equals(password)) {
////				
////				// Si même email et mot de passe -> On redirige vers une autre page
////				connectedConsumer = consumer.getEmail();
//				return "monpanier";
//			} else {
//
//				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("consumerForm");
//				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
//						new FacesMessage("Identifiants incorrects"));
//			}
//		} else {
//			// Si le user n'existe pas du tout -> on affiche l'erreur dans le formulaire de login
//			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("consumerForm");
//			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
//					new FacesMessage("Consumer non reconnu"));
//		}

		// error :on reste sur la même page
		return "consumer";
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
		return connectedConsumer;
	}

	public void setConnectedConsumer(String connectedConsumer) {
		this.connectedConsumer = connectedConsumer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
