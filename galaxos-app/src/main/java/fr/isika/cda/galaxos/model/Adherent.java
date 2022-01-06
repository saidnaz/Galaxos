package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.util.Objects;

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
@NamedQuery(name = "Adherent.findByEmail", query = "SELECT cons FROM Adherent cons WHERE cons.email = :email_param")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Adherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String email;

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

	public Adherent() {
		super();

	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
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
		return Objects.equals(email, other.email);
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
	public void setEmail(String email2) {
		email = email2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

}
