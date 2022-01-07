package fr.isika.cda.galaxos.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.Post;
import fr.isika.cda.galaxos.viewmodel.PostForm;
@Stateless
public class PostRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780678567918648946L;

	@PersistenceContext
	private EntityManager entityManager;
	
	public Post create(PostForm  PF) {
		Post post = new Post();
		Domain domain = new Domain();
		post.setNom(PF.getNom());
		post.setDescription(PF.getDescription());
		post.setDateStart(PF.getDateStart());
		post.setDateEnd(PF.getDateEnd());
		post.setDomain(domain);
			
		entityManager.persist(post);
		return post;
		
	}

	
	
	
	public Optional<Post>findByName(String nom) {
		
		try {
			return Optional.ofNullable(
					this.entityManager
						.createNamedQuery("Adherent.findByNom", Post.class)
						.setParameter("email_param", nom)
						.getSingleResult()
					);
		} catch(NoResultException ex) {
			System.out.println("Post.findBynom() - not found : " +nom );
		}
		return Optional.empty();
	}
	
	
	
	
	
	public List<Post> findAll() {
		
		return null;
	}

	public Optional<Post> findByConsumer(Long idConsumer) {
		
		return null;
	}

	public List<Post> upcomingPosts() {
		// TODO Auto-generated method stub
		return null;
	}


}
