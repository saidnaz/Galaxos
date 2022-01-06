package fr.isika.cda.galaxos.model.resources;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.roles.Provider;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		  name="TYPE_RESOURCE",
		  discriminatorType=DiscriminatorType.STRING
		)
public abstract class Resource{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRessource;
	
	@Column(name="Name", nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Domain domain;
	
	@ManyToOne()
	private Provider provider;
	
	private String[] photos;
		
	public Resource(String name, Domain domain, String[] photos) {
		super();
		this.name = name;
		this.domain = domain;
		this.photos = photos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String[] getPhotos() {
		return photos;
	}

	public void setPhoto(String[] photos) {
		this.photos = photos;
	}

	public Long getIdRessource() {
		return idRessource;
	}



	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}


}
