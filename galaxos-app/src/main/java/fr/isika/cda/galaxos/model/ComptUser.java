package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComptUser {

	@Id
	private String email;

	@Column(length = 20, name = "motdepasse", nullable = false)
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
		ComptUser other = (ComptUser) obj;
		return Objects.equals(email, other.email) && Objects.equals(mdp, other.mdp);
	}

	
	//Constructeur à vide
	
	public ComptUser() {
		super();
	}
	
	
	//Methode to string pour afficher
	
	@Override
	public String toString() {
		return "ComptUser [email=" + email + ", mdp=" + mdp + ", isAccountValide=" + isAccountValide + "]";
	}

	//TEST
	
	
	

}
