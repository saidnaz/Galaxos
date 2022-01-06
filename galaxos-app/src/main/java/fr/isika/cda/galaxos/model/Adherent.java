package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.roles.Role;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

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

//	    @Enumerated(value = EnumType.STRING)
//	    private Role role = Role.ROLE_USER;

	@OneToMany
	@JoinColumn(name = "adherent_id")
	private List<Role> roles;

	@OneToOne
	@JoinColumn(name = "fkUser")
	private CompteUser user;

	@OneToOne
	@JoinColumn(name = "fkProfil")
	private Profil profil;

	@OneToOne
	@JoinColumn(name = "fkDashboard")
	private Dashboard board;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(Role role) {
		this.roles.add(role);
	}

	public CompteUser getUser() {
		return user;
	}

	public Profil getProfil() {
		return profil;
	}

	public Dashboard getBoard() {
		return board;
	}

	public Long getId() {
		return id;
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

	@Column(name = "motdepasse", nullable = false)
	private String password;

	@Column(name = "Nom", nullable = false)
	private String nom;

	// @Enumerated(value = EnumType.STRING)
	// private Role role = Role.ROLE_USER;

	// @Column(name="Comptevalide", nullable=false)
	// private boolean isAccountNotExpired = true;

	// @Column(name="Comptebloque", nullable=false)
	// private boolean isAccountNotLocked = true;

	// @ManyToOne(fetch=FetchType.EAGER)
	// private Association association;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//		public boolean isAccountNotExpired() {
//			return isAccountNotExpired;
//		}
//		public void setAccountNotExpired(boolean isAccountNotExpired) {
//			this.isAccountNotExpired = isAccountNotExpired;
//		}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//		public boolean isAccountNotLocked() {
//			return isAccountNotLocked;
//		}
//		public void setAccountNotLocked(boolean isAccountNotLocked) {
//			this.isAccountNotLocked = isAccountNotLocked;
//		}

//		public Association getAssociation() {
//			return association;
//		}

//		public void setAssociation(Association association) {
//			this.association = association;
//		}

}
