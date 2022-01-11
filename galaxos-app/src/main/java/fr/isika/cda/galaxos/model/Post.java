package fr.isika.cda.galaxos.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Post.findByNom", query = "SELECT p FROM Post p WHERE p.nom = :nom_param")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPost;
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
    private String Description;
	
    private LocalDate DateStart;
	
    private LocalDate DateEnd;
    
    @Column(nullable=false)
    private Double price;
    
	@Column(nullable=false)
	private String photo;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Adherent adherent;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Domain domain;
	
	
	public Post() {
		super();
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDate getDateStart() {
		return DateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		DateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		DateEnd = dateEnd;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Long getIdPost() {
		return idPost;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	

}
