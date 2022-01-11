package fr.isika.cda.galaxos.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
//@NamedQuery(name = "Profil.findByName", query = "SELECT cons FROM Profil cons WHERE cons.nom = :nom_param")
public class Profil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@Basic(optional = false)
//	private String pseudo;
	
	@Column(length = 100, nullable=false)
	private String nom;

	@Column(length = 100, nullable=false)
	private String prenom;

//	@Temporal(TemporalType.DATE)
//	private Date dateNaissance;
	
	@Size(min = 10, max = 14)
    @Digits(fraction = 0, integer = 12)
    private String telephone;
	
	@Lob
	private String description;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private Byte[] photo;
	
	@OneToOne
	@JoinColumn(name = "fkAdresse")
	private Adresse adresse;
	
//	@OneToOne
//	@JoinColumn(name = fk_adherent)
//	private Adherent adherent;
	
	public Profil() {	
	}
	
	
	
	public Profil(String nom, String prenom, String telephone, String description, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.description = description;
		this.adresse = adresse;
	}

	public Profil(String nom, String prenom, String telephone, String description) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.description = description;
	}


	public Long getId() {
		return id;
	}
	
//	public String getPseudo() {
//		return pseudo;
//	}
//
//	public void setPseudo(String pseudo) {
//		this.pseudo = pseudo;
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

//	public Date getDateNaissance() {
//		return dateNaissance;
//	}
//
//	public void setDateNaissance(Date dateNaissance) {
//		this.dateNaissance = dateNaissance;
//	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

//	public Adherent getDestinataire() {
//		return destinataire;
//	}
//
//	public Adherent getExpediteur() {
//		return expediteur;
//	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Profil [id=");
		builder.append(id);
		
//		builder.append(", pseudo=");
//		builder.append(pseudo);
		
		builder.append(", nom=");
		builder.append(nom);
		
		builder.append(", prenom=");
		builder.append(prenom);
		
//		builder.append(", date de naissance=");
//		builder.append(dateNaissance);
		
		builder.append(", téléphone=");
		builder.append(telephone);
		
		builder.append(", descriptionn=");
		builder.append(description);
		
		builder.append(", photo=");
		builder.append(photo);
		
		builder.append("]");
		
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Profil other = (Profil) obj;
		return Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nom, prenom);
	}

}
