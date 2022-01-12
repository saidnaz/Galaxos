package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.dto.LocationAddForm;
import fr.isika.cda.galaxos.dto.VenteAddForm;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.service.ResourceService;

@ManagedBean
@ViewScoped
public class ResourceBean implements Serializable {

	private static final long serialVersionUID = 3971974683679071136L;
	
	@Inject
	private ResourceService service;
	
	private VenteAddForm venteForm = new VenteAddForm();
	
	private LocationAddForm locationForm = new LocationAddForm();
	
	public String create(String type) {
		System.out.println("hello there! Type is :" + type);
		UIComponent formu;
		Resource resource;
		
		if(type.equals("vente")) {
			formu = FacesContext.getCurrentInstance().getViewRoot().findComponent("addVenteForm");
			resource = service.create(venteForm);
		}
		else if(type.equals("location")) {
			formu = FacesContext.getCurrentInstance().getViewRoot().findComponent("addLocationForm");
			resource = service.create(locationForm);
		}
		else {
			System.out.println("Ohno Ohno Ohnonononono!!");
			return "Création de ressource Impossible";
		}
		return "index?faces-redirect=true";
	}

	public ResourceService getService() {
		return service;
	}

	public void setService(ResourceService service) {
		this.service = service;
	}

	public VenteAddForm getVenteForm() {
		return venteForm;
	}

	public void setVenteForm(VenteAddForm venteForm) {
		this.venteForm = venteForm;
	}

	public LocationAddForm getLocationForm() {
		return locationForm;
	}

	public void setLocationForm(LocationAddForm locationForm) {
		this.locationForm = locationForm;
	}
	
	
	
	
	
}
