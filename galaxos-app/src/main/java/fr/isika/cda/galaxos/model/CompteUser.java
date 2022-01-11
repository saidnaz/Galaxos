package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class CompteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String email;

	@Column(name = "motdepasse", nullable = false)
	private String mdp;

	@Column(name = "CompteValide", nullable = false)
	private boolean isAccountValide = true;
	
	//Vas rejoindre la column fkAdherant 
	
	//GET & SET
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isAccountValide() {
		return isAccountValide;
	}

	public void setAccountValide(boolean isAccountValide) {
		this.isAccountValide = isAccountValide;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//hashcode et equald pour le mail et mdp
	
	@Override
	public int hashCode() {
		return Objects.hash(email, mdp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompteUser other = (CompteUser) obj;
		return Objects.equals(email, other.email) && Objects.equals(mdp, other.mdp);
	}

	
	//Constructeur à vide
	
	public CompteUser() {
		super();
	}
	
	
	//Methode to string pour afficher
	
	@Override
	public String toString() {
		return "ComptUser [email=" + email + ", mdp=" + mdp + ", isAccountValide=" + isAccountValide + "]";
	}

	
	
	
	

}
