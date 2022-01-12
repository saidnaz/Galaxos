package fr.isika.cda.galaxos.dto;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class ResourceAddForm{

	@NotEmpty(message =  "Ce champs doit être rempli")
	private String name;
	
	private List<String> photos;
	
	@NotEmpty(message =  "Ce champs doit être rempli")
	private String tarif;
	
	public ResourceAddForm() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getTarif() {
		return tarif;
	}

	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	
	
}
