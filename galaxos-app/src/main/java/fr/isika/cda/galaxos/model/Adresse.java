package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long idAdresse;
	
	@Column(name="Adresse", nullable=false)
	private String adresse;
	
	@Column(name="Ville", nullable=false)
	private String ville;
	
	@Column(name="Code_Postal", nullable=false)
	private Long codePostal;
	
	
}
