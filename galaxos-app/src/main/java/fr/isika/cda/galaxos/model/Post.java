package fr.isika.cda.galaxos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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
    
    public Post(String nom, String description, LocalDate dateStart, LocalDate dateEnd, Double price, String photo,
			Provider provider, Domain domain) {
		super();
		this.nom = nom;
		Description = description;
		DateStart = dateStart;
		DateEnd = dateEnd;
		this.price = price;
		this.photo = photo;
		this.provider = provider;
		this.domain = domain;
	}

	@Column(nullable=false)
	private String photo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Provider provider;
	
	@ManyToOne(fetch=FetchType.EAGER)
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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
