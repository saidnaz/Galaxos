package fr.isika.cda.galaxos.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.resources.Resource;
//import fr.isika.cda.galaxos.repository.ResourceRepo;
import fr.isika.cda.galaxos.service.ResourceService;
import fr.isika.cda.galaxos.viewmodel.CatalogueResForm;

@ManagedBean
@RequestScoped
public class CatalogueResourceBean {
	
		@Inject
		private ResourceService service;

		private CatalogueResForm form = new CatalogueResForm();

		private List<Resource> resources;

		private Association association;
		
		public CatalogueResourceBean() {
			System.out.println("coucou constructor");
			HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
			String id = req.getParameter("id");
			System.out.println("id cstr" + id);
			if (id.equals("all")) {
				this.resources = service.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				System.out.println("jsui laaa" + id);
				Long idOk = Long.parseLong(id);
				System.out.println("vraiment ok?" + idOk);
				this.resources = service.findByAssociation(idOk);
				System.out.println("loop csttr" + resources.size());
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
				this.resources = service.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				this.resources = service.findByAssociation(Long.parseLong(id));
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
				this.resources = service.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				this.resources = service.findByAssociation(Long.parseLong(id));
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
				resources = service.findAll();
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			} else {
				resources = service.findByAssociation(Long.parseLong(id));
				for(Resource r : resources) {
					System.out.println(r.getName());
				}
			}
			return "catalogueResources";
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
				associations = service.findAll();
			} else {
				associations = service.search(localisation, search, domaine);
			}
			return "catalogueAsso";
		}*/

		
}
