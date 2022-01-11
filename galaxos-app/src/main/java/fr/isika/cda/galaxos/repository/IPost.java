package fr.isika.cda.galaxos.repository;

import java.util.List;

import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.Post;

public interface IPost {
	
	Post findByName(String name);

	List<Post> filterByDomain(Domain domain);
	

	List<Post> upcomingPosts();
	

	List<Post> passedPosts();

}
