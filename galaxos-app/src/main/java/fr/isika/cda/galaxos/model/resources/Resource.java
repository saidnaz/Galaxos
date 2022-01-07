package fr.isika.cda.galaxos.model.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.roles.Provider;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn( 
		  name="TYPE_RESOURCE", 
		  discriminatorType=DiscriminatorType.STRING 
		) 
public abstract class Resource{ 
	
	@Id 
	@Column(name="id_ressource")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long idRessource; 
	 
	@Column(nullable=false) 
	private String name; 
	
	@ManyToOne() 
	private Provider provider; 
	 
	private List<String> photos = new ArrayList<String>(); 
	
	
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

	public List<String> getPhotos() {
		return photos;
	}

	public void addPhotos(String photo) {
		this.photos.add(photo);
	} 
	
	public void removePhotos(String photo) {
		this.photos.remove(photo);
	}

}
