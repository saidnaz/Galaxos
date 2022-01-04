package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.isika.cda.galaxos.model.Association.Etat;

@Entity
@Table(name = "Fiche_Association")
public class FicheAssociation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String rnaNumber;

	@Column(nullable = false)
	private String localisation;
	
	public enum Etat {
		EN_COURS, VALIDE, REFUSE;
	}

	// CONSTRCUTORS
	public FicheAssociation() {
		super();
	}

	public FicheAssociation(Long id, String nom, String rnaNumber, String localisation) {
		super();
		this.id = id;
		this.nom = nom;
		this.rnaNumber = rnaNumber;
		this.localisation = localisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	



	

}
