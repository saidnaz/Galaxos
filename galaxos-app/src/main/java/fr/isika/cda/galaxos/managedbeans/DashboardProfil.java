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
<<<<<<< HEAD
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.ProfilForm;
=======
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;
>>>>>>> dashboardAdherent

@ManagedBean
@ViewScoped
public class DashboardProfil {
	
	@Inject
	private AdherentService service;
	
<<<<<<< HEAD
//	Profil profil = new Profil();
//	CompteUser user = new CompteUser();
	Adresse adresse = new Adresse();
	
	private Adherent adherent;
	private Profil profil;
	private CompteUser user;
	private ProfilForm form = new ProfilForm();
=======
	Profil profil = new Profil();
	CompteUser user = new CompteUser();
	Adresse adresse = new Adresse();
	
	private Adherent adherentConnecte;
>>>>>>> dashboardAdherent
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		profil = (Profil) session.getAttribute("profil");
		user = (CompteUser) session.getAttribute("user");
<<<<<<< HEAD

	}
	
	public String update() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long idAdh = (Long) session.getAttribute("connectedAdherentId");
		adherent = (Adherent) session.getAttribute("connectedAdherent");
		service.updateAdherent(form);
		
		return "";
	}
	
	public String wholeAddress(Adresse adresse) {
		String adresseEntiere = adresse.getNumero() + adresse.getLibelle() + adresse.getCodePostal() + adresse.getVille();
		return adresseEntiere;
		
	}
	
//	public String update(Long idAdh) {	
//		Optional<Adherent> optional1 = service.findAdherentById(idAdh);
//		if (optional1.isPresent()) {
//			adherent = optional1.get();
//			service.updateAdherent(form);
//		}
//		
//		return "";
//	}
=======
		
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
>>>>>>> dashboardAdherent

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
<<<<<<< HEAD
	
	public CompteUser getUser() {
		return user;
	}

	public void setUser(CompteUser user) {
		this.user = user;
	}
=======
>>>>>>> dashboardAdherent

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

<<<<<<< HEAD
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherentConnecte(Adherent adherent) {
		this.adherent = adherent;
	}

	public ProfilForm getForm() {
		return form;
	}

	public void setForm(ProfilForm form) {
		this.form = form;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	
=======
	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}
>>>>>>> dashboardAdherent
	

}
