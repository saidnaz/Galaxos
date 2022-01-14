package fr.isika.cda.galaxos.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.repository.ResourceRepo;
import fr.isika.cda.galaxos.viewmodel.CatalogueResForm;

@ManagedBean
@ViewScoped
public class CatalogueResourceBean {
	
		@Inject
		private ResourceRepo resRepo;

		private CatalogueResForm form = new CatalogueResForm();

		private List<Resource> resources;

		private Association association;
		
		public CatalogueResourceBean() {
			System.out.println("coucou constructor");
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String id = req.getParameter("id");
			if (id.equals("all")) {
				this.resources = resRepo.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				this.resources = resRepo.findByAssociation(Long.parseLong(id));
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			}
		}
		
		@PostConstruct
		public void init() {
			System.out.println("coucou init");
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String id = req.getParameter("id");
			if (id.equals("all")) {
				this.resources = resRepo.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				this.resources = resRepo.findByAssociation(Long.parseLong(id));
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			}
		}
		
		public void onload() {
			System.out.println("coucou init");
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String id = req.getParameter("id");
			if (id.equals("all")) {
				this.resources = resRepo.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				this.resources = resRepo.findByAssociation(Long.parseLong(id));
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			}
		}

		public String afficherPageCatalogue() {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String id = req.getParameter("id");
			if (id.equals("all")) {
				resources = resRepo.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				resources = resRepo.findByAssociation(Long.parseLong(id));
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			}
			return "catalogueResources";
		}

		public ResourceRepo getResRepo() {
			return resRepo;
		}

		public void setResRepo(ResourceRepo resRepo) {
			this.resRepo = resRepo;
		}

		public CatalogueResForm getForm() {
			return form;
		}

		public void setForm(CatalogueResForm form) {
			this.form = form;
		}

		public List<Resource> getResources() {
			return resources;
		}

		public void setResources(List<Resource> resources) {
			this.resources = resources;
		}

		public Association getAssociation() {
			return association;
		}

		public void setAssociation(Association association) {
			this.association = association;
		}

		/*public String search() {
			String domaine = (form.getDomaine() == null) ? "" : form.getDomaine().toString();
			System.out.println(domaine);
			if (localisation.equals("") && search.equals("") && domaine.equals("")) {
				associations = resRepo.findAll();
			} else {
				associations = resRepo.search(localisation, search, domaine);
			}
			return "catalogueAsso";
		}*/

		
}
