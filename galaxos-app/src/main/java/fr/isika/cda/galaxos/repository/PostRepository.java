package fr.isika.cda.galaxos.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.galaxos.dto.MessageDTO;
import fr.isika.cda.galaxos.exceptions.DAOException;
import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Domain;
import fr.isika.cda.galaxos.model.Post;
import fr.isika.cda.galaxos.service.AdherentService;
import fr.isika.cda.galaxos.viewmodel.PostForm;

@Stateless
public class PostRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780678567918648946L;

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private AdherentService AS;

	public Post create(PostForm PF, Association association) {

		Optional<Adherent> optional = AS.findAdherentById(PF.getIdAdherent());

		Post post = new Post();
//		Domain domain = new Domain();

		post.setNom(PF.getNom());
		post.setDescription(PF.getDescription());
		post.setDateStart(PF.getStartDate());
		post.setDateEnd(PF.getEndDate());
		post.setNom(PF.getNom());
		post.setPhoto(PF.getPhoto());
		post.setPrice(PF.getPrice());
		post.setAdherent(optional.get());
		post.setDomain(PF.getDomain());
		post.setAssociation(PF.getAssociation());
		post.setAssociation(association);

		entityManager.persist(post);
		return post;

	}

	public Optional<Post> findByNom(String nom) {

		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Post.findByNom", Post.class)
					.setParameter("nom_param", nom).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Post.findBynom() - not found : " + nom);
		}
		return Optional.empty();
	}

	public Optional<Post> findByIdPost(Long id) {
		try {
			return Optional.ofNullable(this.entityManager.createNamedQuery("Post.findById", Post.class)
					.setParameter("id_param", id).getSingleResult());
		} catch (NoResultException ex) {
			System.out.println("Post.findByid() - not found : " + id);
		}
		return Optional.empty();
	}

//	Query(name = "Post.findByDay", query ="SELECT * FROM Post p where p.dateStart = :LocalDate.now()")
	public List<Post> upcomingPosts() throws DAOException {
		try {
			TypedQuery<Post> query = entityManager
					.createQuery("SELECT p FROM Post p where p.dateStart = :LocalDate.now()", Post.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	// Affich sur la vue
	public List<Post> AffichPosts() throws DAOException {
		try {
			TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post p", Post.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	LocalDate date = LocalDate.now();

	public List<Post> findAll() throws DAOException {
		try {
			TypedQuery<Post> query = entityManager.createQuery("SELECT c FROM Post c ORDER BY c.id", Post.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void deletePost(Post post) throws DAOException {

		try {
			entityManager.remove(entityManager.merge(post));
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Post update(Post p) {

		if (p.getNom() != null) {
			try {

				((PostRepository) entityManager).update(entityManager.merge(p));
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return p;
	}

	public List<Post> search(LocalDate startDate, String search, String domaine) {
		// TODO Auto-generated method stub
		return null;
	}

}
