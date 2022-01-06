package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Association")
@NamedQueries({ @NamedQuery(name = "Association.findById", query = "SELECT a FROM Association a WHERE a.id = :id"),
		@NamedQuery(name = "FicheAssociation.findByName", query = "SELECT a FROM FicheAssociation a WHERE a.nom = :nom"),
		@NamedQuery(name = "FicheAssociation.findByRNA", query = "SELECT a FROM FicheAssociation a WHERE a.rnaNumber = :rnaNumber"),
		 })
public class Association {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@OneToOne
	@JoinColumn(name = "fk_ficheAssociation")
	private FicheAssociation ficheAssociation;

	@OneToOne
	@JoinColumn(name = "fk_ficheAssociation_descriptif")
	private FicheAssoDescriptif ficheAssoDescriptif;

	@OneToOne
	@JoinColumn(name = "fk_ficheAssociation_gestionnaire")
	private FicheAssoGestionnaire ficheAssoGestionnaire;

	@OneToOne
	@JoinColumn(name = "fk_ficheAssociation_comptabilite")
	private FicheAssoCompta ficheAssoCompta;

	@ManyToOne
	@JoinColumn(name = "fk_idDomain", nullable = true)

	private Domain fk_idDomain;

	// @OneToMany(mappedBy = "association")
	// private List<Role> roles;

	public enum Etat {
		EN_COURS, VALIDE, BLOQUE, REJETE;
	}

	// CONSTRUCTORS

	public Association(Long id, Etat etat, FicheAssociation ficheAssociation, Domain fk_idDomain) {
		super();
		this.id = id;
		this.etat = etat;
		this.ficheAssociation = ficheAssociation;
		this.fk_idDomain = fk_idDomain;
	}

	public Association() {
		super();
	}

	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public FicheAssociation getFicheAssociation() {
		return ficheAssociation;
	}

	public void setFicheAssociation(FicheAssociation ficheAssociation) {
		this.ficheAssociation = ficheAssociation;
	}

	public Domain getFk_idDomain() {
		return fk_idDomain;
	}

	public void setFk_idDomain(Domain fk_idDomain) {
		this.fk_idDomain = fk_idDomain;
	}

	public FicheAssoDescriptif getFicheAssoDescriptif() {
		return ficheAssoDescriptif;
	}

	public void setFicheAssoDescriptif(FicheAssoDescriptif ficheAssoDescriptif) {
		this.ficheAssoDescriptif = ficheAssoDescriptif;
	}

	public FicheAssoGestionnaire getFicheAssoGestionnaire() {
		return ficheAssoGestionnaire;
	}

	public void setFicheAssoGestionnaire(FicheAssoGestionnaire ficheAssoGestionnaire) {
		this.ficheAssoGestionnaire = ficheAssoGestionnaire;
	}

	public FicheAssoCompta getFicheAssoCompta() {
		return ficheAssoCompta;
	}

	public void setFicheAssoCompta(FicheAssoCompta ficheAssoCompta) {
		this.ficheAssoCompta = ficheAssoCompta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Association [id=");
		builder.append(id);
		builder.append(", etat=");
		builder.append(etat);
		builder.append(", ficheAssociation=");
		builder.append(ficheAssociation);
		builder.append(", fk_idDomain=");
		builder.append(fk_idDomain);
		builder.append("]");
		return builder.toString();
	}

}
