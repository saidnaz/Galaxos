package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idService;
	
	@Column(name="Name", nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Domain domain;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service( String name, Domain domain) {
		super();
		
		this.name = name;
		this.domain = domain;
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

	public Long getIdService() {
		return idService;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, idService);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		return Objects.equals(domain, other.domain) && Objects.equals(idService, other.idService);
	}
	
	

}
