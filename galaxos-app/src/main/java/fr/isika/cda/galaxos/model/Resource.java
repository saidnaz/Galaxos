package fr.isika.cda.galaxos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRessource;
	
	@Column(name="Name", nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Domain domain;
	
	private String photo;
		
	public Resource(String name, Domain domain, String photo) {
		super();
		this.name = name;
		this.domain = domain;
		this.photo = photo;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getIdRessource() {
		return idRessource;
	}



	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}


}
