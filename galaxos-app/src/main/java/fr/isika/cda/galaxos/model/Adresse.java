package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresse {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Numéro", nullable=false)
	private String numero;
	
	@Column(name="Libellé", nullable=false)
	private String libelle;
	
	@Column(name="Ville", length=60, nullable=false)
	private String ville;
	
	@Column(name="Code_Postal", nullable=false)
	private Integer codePostal;
	
//	@OneToOne(mappedBy = "adresse")
//	 private Profil profil;
	
	public Adresse() {
		
	}
	
	
	
	public Adresse(String numero, String libelle, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.ville = ville;

	}



	public Long getId() {
		return id;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String wholeAddress(Adresse adresse) {
		String adresseEntiere = adresse.getNumero() + adresse.getLibelle() + adresse.getCodePostal() + adresse.getVille();
		return adresseEntiere;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Adresse [idAresse=");
		builder.append(id);
		
		builder.append(", numéro=");
		builder.append(numero);
		
		builder.append(", libellé=");
		builder.append(libelle);
		
		builder.append(", ville=");
		builder.append(ville);
		
		builder.append(", code postal=");
		builder.append(codePostal);

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
		
		Adresse other = (Adresse) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero) && 
				Objects.equals(libelle, other.libelle) && Objects.equals(ville, other.ville)
				&& Objects.equals(codePostal, other.codePostal);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, numero, libelle, ville, codePostal);
	}
	
	
}
