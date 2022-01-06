package fr.isika.cda.galaxos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import fr.isika.cda.galaxos.model.resources.Resource;

@Entity
@NamedQuery(name = "Domain.findDomaine", query = "SELECT d FROM Domain d WHERE d.name = :name")
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDomain;

	@Column(name = "NomDomaine", nullable = false)
	@Enumerated(EnumType.STRING)
	private Domaine name;

	@OneToMany(mappedBy = "domain")
	private List<Service> services;

	@OneToMany(mappedBy = "domain")
	private List<Resource> resource;

	@OneToMany(mappedBy = "fk_idDomain")
	private List<Association> associations = new ArrayList<>();

	public Domain() {
		super();
	}

	public Domain(Long idDomain, Domaine name, List<Service> services, List<Resource> resource,
			List<Association> associations) {
		super();
		this.idDomain = idDomain;
		this.name = name;
		this.services = services;
		this.resource = resource;
		this.associations = associations;
	}

	public Long getIdDomain() {
		return idDomain;
	}

	public void setIdDomain(Long idDomain) {
		this.idDomain = idDomain;
	}

	public Domaine getName() {
		return name;
	}

	public void setName(Domaine name) {
		this.name = name;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

}
