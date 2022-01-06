package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("VENTE")
public class Vente extends Resource{

	private Double prix;
	
	private boolean isDispo;
}
