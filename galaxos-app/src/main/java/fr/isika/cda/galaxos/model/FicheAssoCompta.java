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
		EN_COURS, VALIDE, REFUSE;
	}

}
