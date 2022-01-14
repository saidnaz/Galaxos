package fr.isika.cda.galaxos.managedbeans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.isika.cda.galaxos.exceptions.DAOException;
import fr.isika.cda.galaxos.helper.UploadHelper;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.Domaine;
import fr.isika.cda.galaxos.model.Post;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.service.AssociationCompteService;
import fr.isika.cda.galaxos.service.PostService;
import fr.isika.cda.galaxos.viewmodel.PostForm;

@ManagedBean
@ViewScoped
public class PostBean {

	private String nom;

	private String Description;

	private Date startDate;

	private Date endDate;

	private Double price;

	private Domain domain;
	private Domaine selectedDomaine;
	private Part photo;

	private LocalDate convertTo(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Part getPhoto() {
		return photo;
	}

	public Domaine getSelectedDomaine() {
		return selectedDomaine;
	}

	public void setSelectedDomaine(Domaine selectedDomaine) {
		this.selectedDomaine = selectedDomaine;
	}

	public void setPhoto(Part photo) {
		this.photo = photo;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public PostBean() {
		super();

	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Domaine[] getDomaines() {
		return Domaine.values();
	}

	/////////////////////////////////////////////////////////

	@Inject
	private PostService PS;

	@Inject
	private AssociationCompteService service;

	PostForm pform = new PostForm();

	private Post p;

	@Inject
	private AdherentService AS;

	private Association asso;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String idString = params.get("idAsso");
		System.out.println("idstring" + idString);
		if (idString != null) {
			Long idAsso = Long.parseLong(idString);

			Optional<Association> optional = service.findById(idAsso);
			if (optional.isPresent()) {
				asso = optional.get();
			}
		}

	}

	public String create() {
		
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optional = AS.findAdherentById(id);

		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createp");
		if (optional.isPresent()) {
			Adherent adherent = optional.get();
			try {

				System.out.println("adh : " + adherent);

				LocalDate startDateLocal = convertTo(startDate);
				LocalDate endDateLocal = convertTo(endDate);
				System.out.println("start : " + startDateLocal);
				System.out.println("end : " + endDateLocal);

				UploadHelper uploadHelper = new UploadHelper();
				String photoFile = uploadHelper.processUpload(photo);

				pform.setNom(nom);
				pform.setDescription(Description);

				domain = new Domain();
				domain.setName(selectedDomaine);

				pform.setDomain(domain);
				pform.setStartDate(startDateLocal);
				pform.setEndDate(endDateLocal);
				pform.setPhoto(photoFile);
				pform.setPrice(price);
				// pform.setAssociation(asso);
				pform.setIdAdherent(id);
				p = PS.create(pform, asso);

				return "index?faces-redirect=true";

			} catch (Exception ex) {
				FacesContext.getCurrentInstance().addMessage("createp", new FacesMessage(ex.getMessage()));

			}

		} else {
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage());
			return "createAccount";
		}
		return "poster";
	}

	public List<Post> getALLPost() throws DAOException {

		List<Post> plist = PS.AffichPosts();
		return plist;
	}

	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}

}
