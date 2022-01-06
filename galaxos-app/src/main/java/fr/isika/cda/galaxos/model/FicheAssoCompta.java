package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.Part;

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
	private String rib;

	@Column(nullable = true)
	private Double commission;

	public enum Etat {
		EN_ATTENTE_DE_VALIDATION, VALIDE, REFUSE;
	}

	public FicheAssoCompta() {
		super();
	}

	public FicheAssoCompta(Long id, Etat etat, String rib, Double commission) {
		super();
		this.id = id;
		this.etat = etat;
		this.rib = rib;
		this.commission = commission;
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

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}


	
}
