package fr.isika.cda.galaxos.viewmodel;


import java.time.LocalDate;

import javax.servlet.http.Part;

import fr.isika.cda.galaxos.model.Domain;


public class PostForm {
	
private String nom;
	

    private String Description;
	
	
  //  private LocalDate DateStart;
	
   // private LocalDate DateEnd;
    
   
    private Double price;

	
	private Part photo;
	
	
	public PostForm(String nom, String description, LocalDate dateStart, LocalDate dateEnd, Double price,Part photo,
			Domain domain) {
		super();
		this.nom = nom;
		Description = description;
		this.price = price;
		this.photo = photo;
		this.domain = domain;
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


//



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


	public PostForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	private Domain domain;
	

}
