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
import fr.isika.cda.galaxos.model.Adresse;
import fr.isika.cda.galaxos.model.Message;
import fr.isika.cda.galaxos.model.Profil;
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
			AdherentForm adherent2 = new AdherentForm("pierrefer@gmail.com", "azer", "Fernand", "Pierre", "User");
			AdherentForm adherent3 = new AdherentForm("manurolin@gmail.com", "azer", "Rolin", "Emmanuel", "User");
			AdherentForm adherent4 = new AdherentForm("michelledumont@outlook.fr", "azer", "Michelle", "Dumont", "User");
			AdherentForm admin1 = new AdherentForm("adminplatform@gmail.com", "admin", "Administrateur", "Galaxos", "Admin");
			
			adherentService.create(adherent1);
			adherentService.create(adherent2);
			adherentService.create(adherent3);
			adherentService.create(adherent4);
			adherentService.create(admin1);

			adherentService.create(new AdherentForm("riridupuis@outlook.fr",	"azer",		"Richard",	"Dupuis", 	"User"));
			adherentService.create(new AdherentForm("leadubois@gmail.com",		"azer",		"Léa",		"Dubois", 	"User"));
			adherentService.create(new AdherentForm("sam.moraux75@hotmail.fr",	"azer",		"Sam",		"Moraux", 	"User"));
			adherentService.create(new AdherentForm("philippine.a@hotmail.fr",	"azer",		"Philippine","Aubert", 	"User"));
			adherentService.create(new AdherentForm("martinleg@gmail.com.fr",	"azer",		"Martin",	"Legrand", 	"User"));
			adherentService.create(new AdherentForm("clementlefebvre@outlook.fr","azer",	"Clément",	"Lefebvre", "User"));
			adherentService.create(new AdherentForm("philippe.agaciak@outlook.fr","azer",	"Philippe",	"Agaciak", 	"User"));
			adherentService.create(new AdherentForm("cecile.lepillouer@outlook.fr","azer",	"Cécile",	"Le Pillouer", "User"));
			adherentService.create(new AdherentForm("tania.rojas@gmail.com",	"azer",		"Tania",	"Rojas", 	"User"));
			adherentService.create(new AdherentForm("naziha.saidane@outlook.fr","azer",		"Naziha",	"Saidane", 	"User"));
			adherentService.create(new AdherentForm("valentin.zawartoski@outlook.fr","admin","Valentin","Zawartoski", "Admin"));
			
			
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
			
			Adherent ad2 = getAd("manurolin@gmail.com");
			Adherent ad3 = getAd("michelledumont@outlook.fr");
			Adherent ad4 = getAd("pierrefer@gmail.com");
			Adherent ad5 = getAd("riridupuis@outlook.fr");
			Adherent ad6 = getAd("leadubois@gmail.com");
			Adherent ad7 = getAd("sam.moraux75@hotmail.fr");
			Adherent ad8 = getAd("philippine.a@hotmail.fr");
			Adherent ad9 = getAd("martinleg@gmail.com.fr");
			Adherent ad10 = getAd("clementlefebvre@outlook.fr");
			Adherent adcecile = getAd("cecile.lepillouer@outlook.fr");
			Adherent adphil = getAd("philippe.agaciak@outlook.fr");
			Adherent adtania = getAd("tania.rojas@gmail.com");
			Adherent adnaziha = getAd("naziha.saidane@outlook.fr");
			Adherent adval = getAd("valentin.zawartoski@outlook.fr");
			
			
			
			// nouveau profil et adresse écrase l'ancien avec la clé ID
			
			adcecile.getProfil().modifProfil("06 85 46 23 95", "Cecile.png", 
					"Joueuse de badminton", "24", "route de l'église", 78955, "Carrieres sous poissy");
			
			adphil.getProfil().modifProfil("06 56 19 75 23", "Phil.png", 
					"Incollable sur les références cinématographiques","36", "rue de la plage", 14800, "Deauville"); 
			
			adtania.getProfil().modifProfil("06 16 84 34 78", "Tania.png", 
					"", "156", "Avenue de Daumont", 78710, "Rosny-sur-Seine");
			
			adnaziha.getProfil().modifProfil("06 65 12 38 43", "Naziha.png", 
					"", "127", "Boulevard Voltaire", 75006, "Paris");
			
			adval.getProfil().modifProfil("07 56 94 72 18", "val.png", 
					"", "76", "rue de la Mairie", 78530, "Buc");
			
			adSimon.getProfil().modifProfil("06 81 49 34 67", "simon.png", 
					"", "18", "route du Château d'eau", 62500, "Saint-Omer");
			
			admin.getProfil().modifProfilAdmin("01 40 06 61 50", "logo.png", "Administrateur de la Plateforme Galaxos");
			
			addProfilBDD(adcecile);
			addProfilBDD(adphil);
			addProfilBDD(adtania);
			addProfilBDD(adnaziha);
			addProfilBDD(adval);
			addProfilBDD(adSimon);
			addProfilBDD(admin);
			
			Message msg1 = new Message("Bonjour, j'ai un probleme avec un provider, il n'a toujours pas effectué le service qu'il me devait, comment je peux me faire rembourser ?", adSimon, admin, "05/01/2022 - 19:33");
			Message msg2 = new Message("Bonjour, pouvez m'envoyer le devis reçu de ce service qui n'a pas été effectué à cette adresse email s'il vous plait : adminplatform@gmail.com. Nous traiterons votre demande à la reception de ce devis. Cordialement, L'equipe Galaxos", admin, adSimon, "06/01/2022 - 09:47");
			
			
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
				session.setAttribute("count", 0);
				
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
	
	
	
	
	// Methodes pour envoyer des exemples en BDD
	
	public void msgBDD(Message msg)
	{
		msgService.envoyer(msg);
	}
	
	public void addProfilBDD(Adherent adherent)
	{
		adherentService.updateAdherentBDD(adherent);
	}
	
	public Adherent getAd(String email)
	{
		Optional<Adherent> adherentOpt = adherentService.findByEmail(email);
		if (adherentOpt.isPresent()) {
			return adherentOpt.get();
		}
		else return null;
	}

}
