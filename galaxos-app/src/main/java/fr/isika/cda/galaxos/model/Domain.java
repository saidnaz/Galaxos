package fr.isika.cda.galaxos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.isika.cda.galaxos.model.resources.Resource;

@Entity
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDomain;

	@Column(name = "NomDomaine", nullable = false)
	private String name;

	@OneToMany(mappedBy = "domain")
	private List<Service> services;
	/*
	@OneToMany(mappedBy = "domain")
	private List<Resource> resource;
*/
	@OneToMany(mappedBy = "fk_idDomain")
	private List<Association> associations = new ArrayList<>();

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Domain(String name, List<Service> services) {
		super();
		this.name = name;
		this.services = services;
	}

	public Domain() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdDomain() {
		return idDomain;
	}

}
