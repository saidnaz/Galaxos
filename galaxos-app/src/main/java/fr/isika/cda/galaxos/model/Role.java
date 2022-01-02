package fr.isika.cda.galaxos.model;

import javax.persistence.*;

@Entity
public abstract class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn()
	private Adherent adherent;
	
	@OneToOne
	@JoinColumn()
	private Association association;
	
	
	
}
