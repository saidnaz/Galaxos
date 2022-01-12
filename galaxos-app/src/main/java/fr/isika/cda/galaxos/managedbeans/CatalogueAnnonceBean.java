package fr.isika.cda.galaxos.managedbeans;

	import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedBean;
	import javax.faces.bean.RequestScoped;
	import javax.faces.context.FacesContext;
	import javax.inject.Inject;
	import javax.servlet.http.HttpServletRequest;

import fr.isika.cda.galaxos.exceptions.DAOException;
import fr.isika.cda.galaxos.model.Association;
	import fr.isika.cda.galaxos.model.Domaine;
	import fr.isika.cda.galaxos.model.Post;
	import fr.isika.cda.galaxos.repository.PostRepository;
	import fr.isika.cda.galaxos.viewmodel.CatalogueAssoForm;
import fr.isika.cda.galaxos.viewmodel.CataloguePostForm;

	@ManagedBean(name = "CatalogueBean")
	@RequestScoped
	public class CatalogueAnnonceBean {

		@Inject
		private PostRepository PR;

		private CataloguePostForm form = new CataloguePostForm();

		private List <Post> posts;

		private String search;
		private LocalDate startDate;
		
		private String cate;
		private Domaine domaines;

		public String afficherPageCatalogue() {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
								String categName = req.getParameter("categName");
								if (categName.equals("all")) {
									try {
										posts = PR.AffichPosts();}
									catch (DAOException e) {
										
										e.printStackTrace();
									}
								}		  
										return "listAnnonces";
										}

//		public String search() {
//			String domaine = (form.getDomaine() == null) ? "" : form.getDomaine().toString();
//			System.out.println(domaine);
//			if (date.equals("") && search.equals("") && domaine.equals("")) {
//				posts = PR.findAll();
//			} else {
//				posts = PR.search(startDate, search, domaine);
//			}
//			return "listAnnonces";
//		}

		public PostRepository getPR() {
			return PR;
		}

		public void setService(PostRepository pr) {
			this.PR = pr;
		}

		

		public List<Post> getPosts() {
			return posts;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}

		public void setposts(List<Post> posts) {
			this.posts = posts;
		}

	
		

		public CataloguePostForm getForm() {
			return form;
		}

		public void setForm(CataloguePostForm form) {
			this.form = form;
		}

		public String getCate() {
			return cate;
		}

		public void setCate(String cate) {
			this.cate = cate;
		}

		public Domaine[] getDomaines() {
			return Domaine.values();
		}

	


		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		public void setDomaines(Domaine domaines) {
			this.domaines = domaines;
		}
		
		

		

	}



