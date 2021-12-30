package fr.isika.cda.galaxos.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import fr.isika.cda.galaxos.model.Association.Etat;

@Entity
@Table (name = "Devis")
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Etat etat;
	
	@Column(nullable = false, name="Prix")
	private String Prix;
	
	
	@Column(nullable = false,name = "DateDevis")
	private LocalDateTime dateDevis;
	
	@Column(nullable = false,name = "DebutPrestation")
	private LocalDateTime dateDebutPrestation;
	
	@Column(nullable = false,name = "FinPrestation")
	private LocalDateTime dateFinPrestation;
	
	@Lob
	@Column(nullable = false, name ="Document")
	private Byte[] file;
	
	@Column(nullable = false, name="NbrDevis")
	private String nbrDevis;
	
	
//	@OneToOne
//	@JoinColumn(name = fk_adherent)
//	private Adherent adherent;
	
//	@OneToOne
//	@JoinColumn(name = fk_Provider)
//	private Provider provider;
	
	
//	@OneToOne
//	JoincColum(name=fk_Prestation)
//	private Prestatation prestation;
	
	
	//Getter and SET
	
	

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getPrix() {
		return Prix;
	}

	public void setPrix(String prix) {
		Prix = prix;
	}

	public LocalDateTime getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(LocalDateTime dateDevis) {
		this.dateDevis = dateDevis;
	}

	public LocalDateTime getDateDebutPrestation() {
		return dateDebutPrestation;
	}

	public void setDateDebutPrestation(LocalDateTime dateDebutPrestation) {
		this.dateDebutPrestation = dateDebutPrestation;
	}

	public LocalDateTime getDateFinPrestation() {
		return dateFinPrestation;
	}

	public void setDateFinPrestation(LocalDateTime dateFinPrestation) {
		this.dateFinPrestation = dateFinPrestation;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public String getNbrDevis() {
		return nbrDevis;
	}

	public void setNbrDevis(String nbrDevis) {
		this.nbrDevis = nbrDevis;
	}

	public Long getId() {
		return id;
	}

	
	//toString pour être visible
	
	@Override
	public String toString() {
		return "Devis [id=" + id + ", etat=" + etat + ", Prix=" + Prix + ", dateDevis=" + dateDevis
				+ ", dateDebutPrestation=" + dateDebutPrestation + ", dateFinPrestation=" + dateFinPrestation
				+ ", file=" + Arrays.toString(file) + ", nbrDevis=" + nbrDevis + "]";
	}

	
	//Constructeur
	
	public Devis(){
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebutPrestation, dateDevis, dateFinPrestation, id, nbrDevis);
	}

	//HashCode et Equals
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Devis other = (Devis) obj;
		return Objects.equals(dateDebutPrestation, other.dateDebutPrestation)
				&& Objects.equals(dateDevis, other.dateDevis)
				&& Objects.equals(dateFinPrestation, other.dateFinPrestation) && Objects.equals(id, other.id)
				&& Objects.equals(nbrDevis, other.nbrDevis);
	}
	
	
	public void DemanderDevis() {
		
		//Methode à créeer.
	}
	
	public void FournirDevis() {
		
		//Methode à créeer
	}

}
