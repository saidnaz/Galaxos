package fr.isika.cda.galaxos.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.roles.Role;
import fr.isika.cda.galaxos.service.AssociationCompteService;

@ManagedBean
@ViewScoped
public class AdherentAssoDash {

	@Inject
	private AssociationCompteService service;

	private List<Association> associationsGestionnaire;

	private List<Association> associationsProvider;

	private List<Association> associationsAdherent;

	private Adherent adherentConnecte;

	private Long idAdherentConnecte;

	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long idAdherentConnecte = (Long) session.getAttribute("connectedAdherentId");
		associationsGestionnaire = service.findAssociationsGestionnaireParAdherent(idAdherentConnecte);
		associationsProvider = service.findAssociationsProviderParAdherent(idAdherentConnecte);
		associationsAdherent = service.findAssociationsAdherentParAdherent(idAdherentConnecte);

		// TO DO find l'idROLE par l'idAdherent et apres appeler la fonction ci-dessous
		// avec l'idRole
		// List<Role> rolesOpt = service.findRoleParAdherent(idAdherentConnecte);

		// Long idRole = role.getId();
		// associations = service.findByGestionnaireAsso(idRole);
	}

	public List<Association> getAssociationsGestionnaire() {
		return associationsGestionnaire;
	}

	public void setAssociationsGestionnaire(List<Association> associationsGestionnaire) {
		this.associationsGestionnaire = associationsGestionnaire;
	}

	public Adherent getAdherentConnecte() {
		return adherentConnecte;
	}

	public void setAdherentConnecte(Adherent adherentConnecte) {
		this.adherentConnecte = adherentConnecte;
	}

	public Long getIdAdherentConnecte() {
		return idAdherentConnecte;
	}

	public void setIdAdherentConnecte(Long idAdherentConnecte) {
		this.idAdherentConnecte = idAdherentConnecte;
	}

	public List<Association> getAssociationsProvider() {
		return associationsProvider;
	}

	public void setAssociationsProvider(List<Association> associationsProvider) {
		this.associationsProvider = associationsProvider;
	}

	public List<Association> getAssociationsAdherent() {
		return associationsAdherent;
	}

	public void setAssociationsAdherent(List<Association> associationsAdherent) {
		this.associationsAdherent = associationsAdherent;
	}

}
