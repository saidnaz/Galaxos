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
@Table(name = "Fiche_Association_Comptabilite")
public class FicheAssoCompta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@Column(nullable = true)
	private String RIB;

	@Column(nullable = true)
	private Double commission;

	public enum Etat {
		EN_ATTENTE_DE_VALIDATION, VALIDE, REFUSE;
	}

	public FicheAssoCompta() {
		super();
	}

	public FicheAssoCompta(Long id, Etat etat, String rIB, Double commission) {
		super();
		this.id = id;
		this.etat = etat;
		RIB = rIB;
		this.commission = commission;
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

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

}
