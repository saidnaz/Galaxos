package fr.isika.cda.galaxos.managedbeans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.isika.cda.galaxos.helper.UploadHelper;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.service.PostService;
import fr.isika.cda.galaxos.viewmodel.PostForm;

@ManagedBean
@ViewScoped
public class PostBean {

	private String nom;

	private String Description;

	private Date startDate; // conversion a LocalDate

	private Date endDate;

	private Double price;

	private Domain domain;
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

	/////////////////////////////////////////////////////////

	@Inject
	private PostService PS;

	PostForm pform = new PostForm();

	@Inject
	private AdherentService AS;

	public String create() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("connectedAdherentId");
		Optional<Adherent> optional = AS.findById(id);

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
				
				pform = new PostForm();
				pform.setNom(nom);
				pform.setDescription(Description);
				pform.setDomain(domain);
				pform.setStartDate(startDateLocal);
				pform.setEndDate(endDateLocal);
				pform.setPhoto(photoFile);
				pform.setPrice(price);
				
				pform.setIdAdherent(id);
				PS.create(pform);
				
				return "listAnnonces?faces-redirect=true";

			} catch (Exception ex) {
				FacesContext.getCurrentInstance().addMessage("createp", new FacesMessage(ex.getMessage()));

			}

		} else {
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage());
			return "createAccount";
		}
		return "poster";
	}

}
