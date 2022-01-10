package fr.isika.cda.galaxos.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;

import java.util.Optional;

import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import fr.isika.cda.galaxos.exceptions.DAOException;
import fr.isika.cda.galaxos.model.Post;

import fr.isika.cda.galaxos.repository.PostRepository;
import fr.isika.cda.galaxos.viewmodel.PostForm;

@Stateless
public class PostService  implements  Serializable{
	
	
	private static final long serialVersionUID = -8572276956761602694L;
	private static final String PATH_DISK ="D:/Galaxos/src/main/webapp/";
	private static final int SIZE_BUFFER = 10240;
	
	@Inject
	PostRepository PR = new PostRepository();
	


	
	
	public Post create(PostForm Pform) {
		
		
		Optional<Post> name= PR.findByNom(Pform.getNom());
		

		if( name.isPresent() ) {
			        
			throw new EntityNotFoundException("l'annonce existe déjà");
		}

		return PR.create(Pform);
		}
	

	
		public Optional<Post> findByNom(String n) {
			return PR.findByNom(n);}
		
	
	
		
		//upload File
			public String saveFile(Part file, String folder) {
				
				String filename = file.getName().trim();
				
				String shortNameFile = filename.substring(0, filename.lastIndexOf("."));
				String extensionFile = filename.substring(filename.lastIndexOf("."));
				
				filename = shortNameFile + new Date().getTime() + extensionFile;
				
				File newFile = Paths.get(PATH_DISK, folder, filename).toFile();

				try (InputStream input = file.getInputStream();
					BufferedInputStream bufferIn = new BufferedInputStream(input);
					BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(newFile))){
					
					byte[] tampon = new byte[SIZE_BUFFER];
		            int longueur = 0;
		            
		            while ((longueur = bufferIn.read(tampon)) > 0) {
		                bufferOut.write(tampon, 0, longueur);
		            }

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return  folder + "/" + newFile.getName();}
			
				
		
	//Delete	
 	public void delete(Post p) throws DAOException {
	
 		PR.deletePost(p);}
 	
 	//Update
 	public Post update(Post p) {
	return PR.update(p);
 	}
	
	
	public Optional<Post> findById(Long id) {
		return PR.findByIdPost(id);}
	
	
}
	
		/*
		 * public List<Post> postList() {
		 * 
		 * return ( PR.findAll(); }
		 * 
		 * 
		 * public void updatePost(Post pt) { //PS.create(pt); }
		 * 
		 * 
		 * public void deletePost(Long id) {
		 * 
		 * String post = PR.findById(id).get().getPoster(); String filename =
		 * post.substring(30); File file = new
		 * File("./src\\main\\webapp\\uploads\\"+filename); if (file.delete())
		 * {System.out.println("file deleted");}else
		 * {System.out.println("file not deleted");} PR.deleteById(id); }
		 * 
		 * 
		 * public Post findbyId(Long id) { return ER.findById(id).get(); }
		 * 
		 * 
		 * public Post findPostByName(String name) { return PR.findByName(name); }
		 * 
		 * 
		 * public List<Post> filterPost(Domain category) { return
		 * PR.filterByDomain(category); }
		 * 
		 * public List<Post> upcomingPosts() { List<Post> list= PR.upcomingPosts();
		 * return list; }
		 * 
		 * 
		 * public List<Post> passedPosts() { List<Post> list= ER.passedPosts(); return
		 * list; }
		 */


