package fr.isika.cda.galaxos.viewmodel;

import java.time.LocalDate;

import fr.isika.cda.galaxos.model.Domain;

public class PostForm {

	private String nom;

	private Long idAdherent;
	
	private String Description;

	private LocalDate startDate;

	private LocalDate endDate;

	private Double price;

	private String photo;

	public Long getIdAdherent() {
		return idAdherent;
	}
	public void setIdAdherent(Long idAdherent) {
		this.idAdherent = idAdherent;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public PostForm() {
		super();
	}

	private Domain domain;

}
