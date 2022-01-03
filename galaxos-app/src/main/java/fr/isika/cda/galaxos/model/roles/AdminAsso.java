package fr.isika.cda.galaxos.model.roles;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;


@Entity
@Table(name="admins_assos")
@PrimaryKeyJoinColumn(name="id")
public class AdminAsso extends Role{

	public AdminAsso() {}
}
