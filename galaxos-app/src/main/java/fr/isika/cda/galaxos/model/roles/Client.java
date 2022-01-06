package fr.isika.cda.galaxos.model.roles;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*@SecondaryTable(
	    name = "clients",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))*/
public abstract class Client extends Role{
	
	@OneToOne(cascade = CascadeType.ALL)
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
