package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("VENTE")
public class Vente extends Resource{
	
	private boolean isDispo;

	public Vente() {
	}

	public Vente(boolean isDispo) {
		super();
		this.isDispo = isDispo;
	}

	public boolean isDispo() {
		return isDispo;
	}

	public void setDispo(boolean isDispo) {
		this.isDispo = isDispo;
	}
}
