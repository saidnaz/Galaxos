package fr.isika.cda.galaxos.managedbeans;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.OrderLine;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.Resource;
import fr.isika.cda.galaxos.service.PanierService;

@ManagedBean(name="PanierBean")
@ViewScoped
public class PanierBean {
	 
	 	@Inject
	 	private PanierService panierService;
	 
	 	private Panier monpanier;
		private Integer myquantity;
		
		private Iterator <OrderLine> myorderlines;
		
		private List<Resource> mesressources;
		private Long  panierId;
		private CompteUser userconnected;
		private float sommeDesAchats;
		
		
		////////////////////////Methodes////////////////////////////////////////////
		
			public String addRessourceToPanier(Long idRessource){
			Panier cart = panierService.SearchCartByUser(userconnected.getEmail());
			
			panierService.addToCart(idRessource, cart.getIdPanier(), userconnected.getEmail());
			String navigateTo = "";
			FacesMessage facesMessage = new FacesMessage("La ressource est ajoutée au panier avec succes");
			FacesContext.getCurrentInstance().addMessage("", facesMessage);
			//navigateTo = "/listRessource.xhtml?faces-redirect=true";
			return null;}
			
			//naviguer vers mon panier
			public String ToMyCart() {
				String navigateTo = "/monpanier.xhtml?faces-redirect=true";
				return navigateTo;
			}
			

	

	 
		
		/////////////////////////////////////Getters//Setters////////////////////////////////////////////
		public PanierService getPanierService() {
			return panierService;
		}




		public void setPanierService(PanierService panierService) {
			this.panierService = panierService;
		}




		public Panier getMonpanier() {
			return monpanier;
		}




		public void setMonpanier(Panier monpanier) {
			this.monpanier = monpanier;
		}




		public Integer getMyquantity() {
			return myquantity;
		}




		public void setMyquantity(Integer myquantity) {
			this.myquantity = myquantity;
		}




		public List<Resource> getMesressources() {
			return mesressources;
		}




		public void setMesressources(List<Resource> mesressources) {
			this.mesressources = mesressources;
		}




		public Long getPanierId() {
			return panierId;
		}




		public void setPanierId(Long panierId) {
			this.panierId = panierId;
		}








		public float getSommeDesAchats() {
			return sommeDesAchats;
		}




		public void setSommeDesAchats(float sommeDesAchats) {
			this.sommeDesAchats = sommeDesAchats;
		}



	 
	
	
}
