package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ProfilForm implements Serializable {

	private static final long serialVersionUID = -1223098802231209636L;
	
//	@NotEmpty(message = "Ne doit pas être vide")
//	@NotNull(message = "Ne doit pas être null")
//	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
//	private String nom;

//	@NotEmpty(message = "Ne doit pas être vide")
//	@NotNull(message = "Ne doit pas être null")
//	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
//	private String prenom;
	
	
	@NotNull(message = "Ne doit pas être null")
	//@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String telephone;

//	@NotEmpty(message = "Ne doit pas être vide")
//	@NotNull(message = "Ne doit pas être null")
//	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
//	private String email;
	
	
	@NotNull(message = "Ne doit pas être null")
	//@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String description;
	
	// infos concernant l'adresse

	@NotNull(message = "Ne doit pas être null")
	private String numero;
	

	@NotNull(message = "Ne doit pas être null")
	//@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String libelle;
	
	@NotNull(message = "Ne doit pas être null")
	private Integer codePostal;
	

	@NotNull(message = "Ne doit pas être null")
	private String ville;


//	public String getNom() {
//		return nom;
//	}
//
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


//	public String getEmail() {
//		return email;
//	}
//
//
//	public void setEmail(String email) {
//		this.email = email;
//	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Integer getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	

	public ProfilForm() {
		super();
	}


	public ProfilForm(String telephone, String description, String numero,
			String libelle, Integer codePostal, String ville) {
		super();
		//this.nom = nom;
		//this.prenom = prenom;
		this.telephone = telephone;
		//this.email = email;
		this.description = description;
		this.numero = numero;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	

}
