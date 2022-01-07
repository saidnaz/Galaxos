package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idRessource")
@DiscriminatorValue("VENTE")
public class Vente extends Resource{

	private Double prix;
	
	private boolean isDispo;

	public Vente() {
	}

	public Vente(Double prix, boolean isDispo) {
		super();
		this.prix = prix;
		this.isDispo = isDispo;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public boolean isDispo() {
		return isDispo;
	}

	public void setDispo(boolean isDispo) {
		this.isDispo = isDispo;
	}	
}
