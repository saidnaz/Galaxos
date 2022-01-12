package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;

@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("LOCATION")
public class Location extends Resource{
	
	@OneToOne
	private GestionnaireResa gestResa;

	public Location() {}

	public Location(GestionnaireResa gestResa) {
		super();
		this.gestResa = gestResa;
	}

	public GestionnaireResa getGestResa() {
		return gestResa;
	}

	public void setGestResa(GestionnaireResa gestResa) {
		this.gestResa = gestResa;
	}

}
