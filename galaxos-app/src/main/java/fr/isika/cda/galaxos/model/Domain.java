package fr.isika.cda.galaxos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDomain;
	
	@Column(name="NomDomaine", nullable=false)
	private String name;
	
	 @OneToMany(mappedBy ="domain")
	 private List<Service> services;
	 
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
		// TODO Auto-generated constructor stub
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
