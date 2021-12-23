package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ComptUser {

	
	@Id
	private String email;
	
	@Column(length = 20,name="motdepasse", nullable=false)
	private String mdp;

	@Column(name="CompteValide",nullable= false)
	private boolean isAccountValide=true;
	
	@Column(name="CompteClose", nullable=false)
	private boolean isAccountNotValide=true;
	
	@OneToOne
	@JoinColumn(name="fkAdherent")
	private Adherent adherent;
	
	


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


	public boolean isAccountNotValide() {
		return isAccountNotValide;
	}


	public void setAccountNotValide(boolean isAccountNotValide) {
		this.isAccountNotValide = isAccountNotValide;
	}


	public Adherent getAdherent() {
		return adherent;
	}


	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}


	public String getEmail() {
		return email;
	}


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
	

	public ComptUser() {
		super();
	}
	
	
}
