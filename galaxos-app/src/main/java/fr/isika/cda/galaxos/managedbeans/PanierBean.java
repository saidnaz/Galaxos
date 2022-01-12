package fr.isika.cda.galaxos.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.CompteUser;
import fr.isika.cda.galaxos.model.OrderLine;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.service.PanierService;

@ManagedBean(name="PanierBean")

public class PanierBean {
	
@Inject
	private PanierService panierService;

	//private Panier monpanier;
Integer myquantity;
Double price;
Integer ressourceId;
List <OrderLine> myorderlines = new ArrayList<OrderLine>();		
String resourName;
Long  panierId;
Adherent userconnected;
BigDecimal sommeDesAchats;
String item;
int cartsize;
Map<Integer,OrderLine> map = new HashMap<Integer,OrderLine >();






//////////////////////////Getters et Setters////////////////////////////////
public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}
	 
	 	public List<OrderLine> getMyorderlines() {
		return myorderlines;
	}

	public void setMyorderlines(List<OrderLine> myorderlines) {
		this.myorderlines = myorderlines;
	}

	public String getResourName() {
		return resourName;
	}

	

	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Map<Integer, OrderLine> getMap() {
		return map;
	}

	public void setMap(Map<Integer, OrderLine> map) {
		this.map = map;
	}
/////ProcessCart////
	public String processCart() {
		
		OrderLine orderL = new OrderLine();
		orderL.setQuantité(myquantity);
		orderL.setPrix(price);
		orderL.setResourceName(resourName);
		orderL.setTotale( price * myquantity);
		myorderlines.add(orderL);
		map.put(ressourceId, orderL);
		cartsize = myorderlines.size();
		
		
		return null;
	}



			
		
		////////////////////////Methodes////////////////////////////////////////////
		
			public String addRessourceToPanier(Long idRessource){
		//	Panier cart = panierService.SearchCartByUser(userconnected.getEmail());
			
			//panierService.addToCart(idRessource, cart.getIdPanier(), userconnected.getEmail());
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


		public Integer getMyquantity() {
			return myquantity;
		}




		public void setMyquantity(Integer myquantity) {
			this.myquantity = myquantity;
		}

		public Long getPanierId() {
			return panierId;
		}


		public void setPanierId(Long panierId) {
			this.panierId = panierId;
		}



		public BigDecimal getSommeDesAchats() {
			return sommeDesAchats;
		}




		public void setSommeDesAchats(BigDecimal sommeDesAchats) {
			this.sommeDesAchats = sommeDesAchats;
		}



	 
	
	
}
