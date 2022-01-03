package fr.isika.cda.galaxos.model.roles;

import java.util.List;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Post;

@Entity
@Table(name="consumers")
@PrimaryKeyJoinColumn(name="id")
public class Consumer extends Client{

	@OneToOne(cascade = CascadeType.ALL)
	private Association association;
	
	@OneToMany(mappedBy="consumer")
	List<Post> posts;
	
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
	
}
