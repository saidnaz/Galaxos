package fr.isika.cda.galaxos.model.resources;

import java.time.LocalDateTime;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.roles.Provider;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn( 
		  name="TYPE_RESOURCE", 
		  discriminatorType=DiscriminatorType.STRING 
		)
@NamedQueries({
	@NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
	@NamedQuery(name = "Resource.findById", query = "SELECT r FROM Resource r WHERE r.idRessource = :id"),
	@NamedQuery(name = "Resource.findByProv", query = "SELECT r FROM Resource r WHERE r.provider.id = :id")
})
public abstract class Resource{ 
	
	@Id 
	@Column(name="id_resource")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long idRessource; 
	 
	@Column(nullable=false) 
	private String name; 
	
	@ManyToOne() 
	private Provider provider; 
	
	@Column(nullable=false) 
	private Double tarif;
	
	@Column(nullable=false)
	private LocalDateTime datePublication;
	 
	//private List<String> photos = new ArrayList<String>(); 

	public Resource() {}
	
	public Resource(String name) { 
		super(); 
		this.name = name;
	}

	public Long getIdRessource() {
		return idRessource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif= tarif;
	}
	
	public LocalDateTime getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resource [name=");
		builder.append(name);
		builder.append(", tarif=");
		builder.append(tarif);
		builder.append("]");
		return builder.toString();
	}

	/*public List<String> getPhotos() {
		return photos;
	}

	public void addPhotos(String photo) {
		this.photos.add(photo);
	} 
	
	public void removePhotos(String photo) {
		this.photos.remove(photo);
	}*/

	
}
