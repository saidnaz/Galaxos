package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fiche_Association")
public class FicheAssociation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private String logo;

	@Column(nullable = false)
	private String slogan;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private int commission;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	
	@Column(nullable = false)
	private String rnaNumber;

	@Column(nullable = false)
	private String localisation;
	
	public enum Etat {
		EN_ATTENTE_VALIDATION, VALIDE, REFUSE;
	}

	// CONSTRCUTORS
	public FicheAssociation() {
		super();
	}

	// GETTERS & SETTERS
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FicheAssociation [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", logo=");
		builder.append(logo);
		builder.append(", slogan=");
		builder.append(slogan);
		builder.append(", description=");
		builder.append(description);
		builder.append(", rnaNumber=");
		builder.append(rnaNumber);
		builder.append(", commission=");
		builder.append(commission);
		builder.append("]");
		return builder.toString();
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
