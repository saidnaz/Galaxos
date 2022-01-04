package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.Association.Etat;
import fr.isika.cda.galaxos.model.Domain;

public class AssociationCreationForm implements Serializable {

	private static final long serialVersionUID = 3517351584010323699L;

	private Etat etat;

	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String nom;


	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	@Pattern(regexp = "^[A-Z]{1}[0-9]{9}$", message = "Ce champs doit correspondre à un numéro RNA valide")
	private String rnaNumber;

	private Domain fk_idDomain;

	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	@Size(min = 5, max = 5, message = "Doit comporter 5 chiffres")
	private String localisation;

	public AssociationCreationForm() {
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRnaNumber() {
		return rnaNumber;
	}

	public void setRnaNumber(String rnaNumber) {
		this.rnaNumber = rnaNumber;
	}

	public Domain getFk_idDomain() {
		return fk_idDomain;
	}

	public void setFk_idDomain(Domain fk_idDomain) {
		this.fk_idDomain = fk_idDomain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

}
