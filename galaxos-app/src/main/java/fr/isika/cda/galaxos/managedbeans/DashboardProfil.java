package fr.isika.cda.galaxos.managedbeans;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Adresse;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;

@ManagedBean
@ViewScoped
public class DashboardProfil {
	
	@Inject
	private AdherentService service;
	
	Profil profil = new Profil();
	CompteUser user = new CompteUser();
	Adresse adresse = new Adresse();
	
	private Adherent adherentConnecte;
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		profil = (Profil) session.getAttribute("profil");
		user = (CompteUser) session.getAttribute("user");
		
		//		Long id = (Long) session.getAttribute("profilId");
//		
//		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
//		
//		Optional<Adherent> optionalAd = service.findAdherentById(idAdherentConnecte);
//		if (optionalAd.isPresent()) {
//			adherentConnecte = optionalAd.get();
//		}
//		
//		Optional<Profil> optional = service.findProfilById(id);
//		if (optional.isPresent()) {
//			profil = optional.get();
//		}
//		
		
	}

	public DashboardProfil() {
	}


	public AdherentService getService() {
		return service;
	}

	public void setService(AdherentService service) {
		this.service = service;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}
	

}
