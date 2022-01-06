package fr.isika.cda.galaxos.model.roles;

import java.util.List;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.Post;

@Entity
@Table(name="consumers")
@PrimaryKeyJoinColumn(name="id")
public class Consumer extends Client{

	@OneToOne(cascade = CascadeType.ALL)
	private Association association;
	
	@OneToMany(mappedBy="consumer")
	List<Post> posts;
	
	@OneToMany(mappedBy="consumer")
	private List<Panier> panierId;
	
	public Consumer() {}

	public Consumer(Association association, List<Post> posts) {
		super();
		this.association = association;
		this.posts = posts;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
	
	public List<Panier> getPanierId() {
		return panierId;
	}

	public void setPanierId(List<Panier> panierId) {
		this.panierId = panierId;
	}
}
