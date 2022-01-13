package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import fr.isika.cda.galaxos.model.Association;

public class CatalogueResForm implements Serializable {
	
	private static final long serialVersionUID = -8834459413659914276L;
	
	private Association association;

	public CatalogueResForm() {}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}
}
