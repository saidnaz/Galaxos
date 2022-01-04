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
@Table(name = "Fiche_Association_Gestionnaire")
public class FicheAssoGestionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@Column(nullable = true)
	private String pieceIdentite;

	public enum Etat {
		EN_COURS, VALIDE, REFUSE;
	}

	public FicheAssoGestionnaire() {
		super();
	}

	public FicheAssoGestionnaire(Long id, Etat etat, String pieceIdentite) {
		super();
		this.id = id;
		this.etat = etat;
		this.pieceIdentite = pieceIdentite;
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

	public String getPieceIdentite() {
		return pieceIdentite;
	}

	public void setPieceIdentite(String pieceIdentite) {
		this.pieceIdentite = pieceIdentite;
	}
	
	

}
