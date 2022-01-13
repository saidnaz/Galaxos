package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.annotation.PostConstruct;
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
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.repository.Cryptage;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.service.MessageService;
import fr.isika.cda.galaxos.viewmodel.AdherentForm;
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

	@Inject
	private MessageService msgService;
	
	private AdherentForm accountForm = new AdherentForm();

	private String presentRole;
	
	private static boolean init = false;
	
	@PostConstruct
	public void init()
	{
		if (!init)
		{
			AdherentForm adherent1 = new AdherentForm("simon.deb@gmail.com", "azer", "Debuire", "Simon", "User");
			AdherentForm ad2 = new AdherentForm("pierrefer@gmail.com", "azer", "Fernand", "Pierre", "User");
			AdherentForm ad3 = new AdherentForm("manurolin@gmail.com", "azer", "Rolin", "Emmanuel", "User");
			AdherentForm ad4 = new AdherentForm("leadumont@outlook.fr", "azer", "Léa", "Dumont", "User");
			AdherentForm admin1 = new AdherentForm("adminplatform@gmail.com", "admin", "Administrateur", "Plateforme", "Admin");
			
			adherentService.create(adherent1);
			adherentService.create(ad2);
			adherentService.create(ad3);
			adherentService.create(ad4);
			adherentService.create(new AdherentForm("riridupuis@outlook.fr","azer","Richard","Dupuis", "User"));
			adherentService.create(admin1);
			
			Adherent admin = new Adherent();
			Adherent adSimon = new Adherent();
			
			Optional<Adherent> adminOpt = adherentService.findByEmail("adminplatform@gmail.com");
			if (adminOpt.isPresent()) {
				admin = adminOpt.get();
			}
			
			Optional<Adherent> adherentOpt = adherentService.findByEmail("simon.deb@gmail.com");
			if (adherentOpt.isPresent()) {
				adSimon = adherentOpt.get();
			}
				
			Message msg1 = new Message("Bonjour, j'ai un probleme avec un provider, il n'a toujours pas effectué le service qu'il me devait, comment je peux me faire rembourser ?", adSimon, admin);
			Message msg2 = new Message("Bonjour, pouvez m'envoyer le devis reçu de ce service qui n'a pas été effectué à cette adresse email s'il vous plait : adminplatform@gmail.com. Nous traiterons votre demande à la reception de ce devis. Cordialement, L'equipe Galaxos", admin, adSimon);
			msgBDD(msg1);
			msgBDD(msg2);
	//		Message msg1 = new Message("Bonjour, je suis intéréssé pour devenir provider dans votre association, j'aimerais vous poser quelque question avant si possible.", );
			
			
			init = true;
		}
		
//		AdherentForm admin = new AdherentForm("adminplatform@gmail.com", "admin", "Admin", "Admin");
//		AdminPlateforme adminRole = new AdminPlateforme();
//		admin.addRoles(adminRole);
//		accountService.create(admin);
		
		
	}
	
	
	
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
				
				// Paramètrer des données à persister au moment de la connexion avec "set"
				session.setAttribute("connectedAdherentId", adherent.getId());
				session.setAttribute("connectedAdherent", adherent);
				session.setAttribute("profil", adherent.getProfil());
				session.setAttribute("profil", adherent.getProfil().getAdresse());
				session.setAttribute("user", adherent.getUser());
				session.setAttribute("roles", adherent.getRoles());
				session.setAttribute("role", adherent.getRole());
				session.setAttribute("isConnected", true);
				session.setAttribute("compteUser", adherent.getUser());
				
				
				presentRole = (String) session.getAttribute("role");
				
				if (presentRole.contains("User"))
				{
					return "dashboardAdherent?faces-redirect=true";
				}
				
				return "dashboardAdministrateur?faces-redirect=true";
				
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

	public String doLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return "/index?faces-redirect=true";
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

	public String getPresentRole() {
		return presentRole;
	}

	public void setPresentRole(String presentRole) {
		this.presentRole = presentRole;
	}
	
	
	// Methode pour envoyer des exemples messages en bdd
	public void msgBDD(Message msg)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		String str = LocalDateTime.now().format(formatter);
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		msg.setDate(dateTime);
		msgService.envoyer(msg);
		
		
	}

}
