package fr.isika.cda.galaxos.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.roles.Provider;

public abstract class ResourceAddForm{

	@NotEmpty(message =  "Ce champs doit être rempli")
	private String name;
	
	private List<String> photos;
	
	@NotEmpty(message =  "Ce champs doit être rempli")
	private String tarif;
	
	@NotEmpty
	private LocalDateTime date;
	
	@NotEmpty
	private Provider provider;
	
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	
}
