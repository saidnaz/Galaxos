package fr.isika.cda.galaxos.managedbeans;

import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.Post;
import fr.isika.cda.galaxos.service.PostService;
import fr.isika.cda.galaxos.viewmodel.PostForm;

@ManagedBean
@ViewScoped
public class PostBean {

	
	
	@Inject
	private PostService PS ;
	
	PostForm pform = new PostForm();
	
	
	public PostBean() {
		super();
		
	
	}
	public String create() {
		
		
		Adherent ad = new Adherent();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("Id");
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createp");
		
		Optional <Post> optional = PS.;
		
			

			if( optional.equals(null)) {
				
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage());
				
				return "";
			} else 			
				try {

			PS.create(pform);
			return "listAnnonces?faces-redirect=true";

		} catch (Exception ex) {


			FacesContext.getCurrentInstance().addMessage("forumaire", new FacesMessage(ex.getMessage()));
			
		} 
		return "poster";
	}
	
	}	
	
	
	
	
	
	
	
	
	




