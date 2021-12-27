package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private int rnaNumber;

	@Column(nullable = false)
	private int commission;

	// CONSTRCUTORS
	public FicheAssociation() {
		super();
	}

	public FicheAssociation(Long id, String nom, String logo, String slogan, String description, int rnaNumber,
			int commission) {
		super();
		this.id = id;
		this.nom = nom;
		this.logo = logo;
		this.slogan = slogan;
		this.description = description;
		this.rnaNumber = rnaNumber;
		this.commission = commission;
	}

	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getRnaNumber() {
		return rnaNumber;
	}

	public void setRnaNumber(int rnaNumber) {
		this.rnaNumber = rnaNumber;
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

}
