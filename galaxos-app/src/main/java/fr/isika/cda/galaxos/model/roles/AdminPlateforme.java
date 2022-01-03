package fr.isika.cda.galaxos.model.roles;

import javax.persistence.*;

@Entity
@Table(name="admins_plateforme")
@PrimaryKeyJoinColumn(name="id")
public class AdminPlateforme extends Client{

	public AdminPlateforme() {}

	
}
