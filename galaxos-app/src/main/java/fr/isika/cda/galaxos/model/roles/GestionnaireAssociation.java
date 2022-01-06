package fr.isika.cda.galaxos.model.roles;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;

@Entity
@Table(name="gestionnaires_assos")
@PrimaryKeyJoinColumn(name="id")
public class GestionnaireAssociation extends Client{
	
	public GestionnaireAssociation() {}
	
}
