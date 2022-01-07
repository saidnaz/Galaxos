package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.resources.reservations.GestionnaireResa;

@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("LOCATION")
public class Location extends Resource{
	
	private Double tarifJournalier;
	
	@OneToOne
	private GestionnaireResa gestResa;

	public Location() {}

	public Location(Double tarifJournalier, GestionnaireResa gestResa) {
		super();
		this.tarifJournalier = tarifJournalier;
		this.gestResa = gestResa;
	}

	public Double getTarifJournalier() {
		return tarifJournalier;
	}

	public void setTarifJournalier(Double tarifJournalier) {
		this.tarifJournalier = tarifJournalier;
	}

	public GestionnaireResa getGestResa() {
		return gestResa;
	}

	public void setGestResa(GestionnaireResa gestResa) {
		this.gestResa = gestResa;
	}

}
