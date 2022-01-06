package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;

@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("LOCATION")
public class Location extends Resource{
	
	private Double tarifJournalier;
	
	private GestionnaireResa gestResa;
	

}
