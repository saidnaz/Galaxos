package fr.isika.cda.galaxos.dto;

import java.io.Serializable;

public class VenteAddForm extends ResourceAddForm  implements Serializable{

	private static final long serialVersionUID = -314261319532825328L;

	private boolean isDispo;

	public boolean isDispo() {
		return isDispo;
	}

	public void setDispo(boolean isDispo) {
		this.isDispo = isDispo;
	}
	
}