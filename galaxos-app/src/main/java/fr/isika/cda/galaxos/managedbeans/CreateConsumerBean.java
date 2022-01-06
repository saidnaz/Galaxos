package fr.isika.cda.galaxos.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.service.ConsumerService;
import fr.isika.cda.galaxos.viewmodel.ConsumerForm;

@ManagedBean(name="CreateConsumerBean")
@ViewScoped
public class CreateConsumerBean implements Serializable {

	
	private static final long serialVersionUID = -5519952773563441594L;
	
		public CreateConsumerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Inject
		private ConsumerService consumerService;
		
		private ConsumerForm consumerForm = new ConsumerForm();
		
		public String create() {
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createConsumerForm");
			
			// Si les mots de passe et email sont vides
			if( consumerForm.equals(null)){
				// ici utiliser le facescontext pour ajouter le message dynamiquement
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(" Remplir le mot de passe et l'email"));
				
				// rester sur la même page (en gardant les infos du formulaire)
				return "";
			} else {
				try {
					// On appelle le service pour sauvegarder cet objet 
					// (qui a été rempli automatiquement depuis les champs de la page)
					consumerService.create(consumerForm);
					
					// On redirige vers mon panier en cas de compte créé avec succès
					return "panier?faces-redirect=true";
					
				} catch(Exception ex) {
					// On ajoute un message sur la vue qui résume l'exception
					FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
				}
				
				// rester sur la même page en vidant les infos du formulaire (en cas d'erreur)
				return "createConsumer";
			}
		}
		
		public ConsumerForm getConsumerForm() {
			return consumerForm;
		}
		public void setConsumerForm(ConsumerForm consumerForm) {
			this.consumerForm = consumerForm;
		}
		
}
