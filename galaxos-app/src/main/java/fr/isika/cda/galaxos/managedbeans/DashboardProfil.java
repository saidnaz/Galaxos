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

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.ProfilForm;

import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Profil;
import fr.isika.cda.galaxos.service.AdherentService;

@ManagedBean
@ViewScoped
public class DashboardProfil {
	
	@Inject
	private AdherentService service;
	

//	Profil profil = new Profil();
//	CompteUser user = new CompteUser();
	
	private Adresse adresse;
	private Adherent adherent;
	private Profil profil;
	private CompteUser user;
	private ProfilForm form = new ProfilForm();

	
	private Adherent adherentConnecte;
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		profil = (Profil) session.getAttribute("profil");
		user = (CompteUser) session.getAttribute("user");


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

	
	public CompteUser getUser() {
		return user;
	}

	public void setUser(CompteUser user) {
		this.user = user;
	}


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


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
	
	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}


	

}
