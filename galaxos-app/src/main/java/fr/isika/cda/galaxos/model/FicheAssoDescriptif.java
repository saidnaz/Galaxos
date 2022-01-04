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
@Table(name = "Fiche_Association_Descriptif")
public class FicheAssoDescriptif {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@Column(nullable = true)
	private String description;

	@Column(nullable = true)
	private String logo;

	@Column(nullable = true)
	private String slogan;

	public enum Etat {
		EN_ATTENTE_DE_VALIDATION, VALIDE, REFUSE;
	}

	public FicheAssoDescriptif() {
		super();
	}

	public FicheAssoDescriptif(Long id, Etat etat, String description, String logo, String slogan) {
		super();
		this.id = id;
		this.etat = etat;
		this.description = description;
		this.logo = logo;
		this.slogan = slogan;
	}

	public Long getId() {
		return id;
	}


	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
