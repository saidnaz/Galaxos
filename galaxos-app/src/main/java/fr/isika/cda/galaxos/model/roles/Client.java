package fr.isika.cda.galaxos.model.roles;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Client extends Role{
	
	@OneToOne
	private Association association;
	
	public Client() {}

	public Client(Association association) {
		super();
		this.association = association;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}
	

}
