package fr.isika.cda.galaxos.model;


import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="providers")
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProvider;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//private Adherent adherent;
	
	@OneToMany(mappedBy="provider")
	List<Post> posts;

	public Provider() {
		
		
	}
	
	public Provider(Long idProvider, List<Post> posts) {
		super();
		this.idProvider = idProvider;
		//this.adherent = adherent;
		this.posts = posts;
	}



	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Provider other = (Provider) obj; return Objects.equals(adherent,
	 * other.adherent) && Objects.equals(idProvider, other.idProvider); }
	 */

	public Long getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}

	/*
	 * public Adherent getAdherent() { return adherent; }
	 * 
	 * public void setAdherent(Adherent adherent) { this.adherent = adherent; }
	 */

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	

	
	
	

}
