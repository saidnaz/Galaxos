package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.roles.Role;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.galaxos.model.roles.Role;

@Entity
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "type")
@NamedQuery(name = "Adherent.findByEmail", query = "SELECT cons FROM Adherent cons JOIN cons.user cptu WHERE cons.user.email = :email_param")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Adherent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany
	@JoinColumn(name = "adherent_id")
	private List<Role> roles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkUser")
	private CompteUser user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkProfil")
	private Profil profil;

	@OneToOne
	@JoinColumn(name = "fkDashboard")
	private Dashboard board;

	public Long getId() {
		return id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	// TODO : addRole(...) et removeRole(....) et initialiser la liste aussi à vide
	// !!
//	public void setRoles(Role role) {
//		this.roles.add(role);
//	}

	public CompteUser getUser() {
		return user;
	}

	public void setUser(CompteUser user) {
		this.user = user;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Dashboard getBoard() {
		return board;
	}

	public Adherent() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adherent other = (Adherent) obj;
		return Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Profil [id=");
		builder.append(id);

		builder.append(", user=");
		builder.append(user);

		builder.append(", profil=");
		builder.append(profil);

		builder.append(", dashBoard=");
		builder.append(board);

		builder.append("]");

		return builder.toString();
	}

}
