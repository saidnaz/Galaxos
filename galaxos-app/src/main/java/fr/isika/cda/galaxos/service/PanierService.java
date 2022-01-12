package fr.isika.cda.galaxos.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.OrderLine;
import fr.isika.cda.galaxos.model.Panier;
import fr.isika.cda.galaxos.model.resources.Resource;
import fr.isika.cda.galaxos.repository.AdherentRepository;
import fr.isika.cda.galaxos.repository.ConsumerRepository;
import fr.isika.cda.galaxos.repository.PanierRepository;


@Stateful
public class PanierService {


	
	@Inject
	 PanierRepository panierRepository ;
	private Adherent ad ;
	 @Inject
	 AdherentRepository AR;
	
	public void addToCart(Long idRessource,Long id,String useremail) {
	
//	Adherent p   = PanierRepository.findByIdPanier(id).get();
	//Ressource  = ressourceRepository.findById(idRessource).get();
	 AR.findByEmail(useremail).get();
	
	}
	
	
	
	//Ajouter une ligne de commande à mon panier
	public void addOrderLineToMyCart(OrderLine orderEntity)
	{
    
		  
		LocalDateTime date= LocalDateTime.now();
		if (panierRepository.findById(ad).isEmpty()) {
			List<OrderLine> result = new ArrayList<>();
			result.add(orderEntity);
		//	Panier p1 = new Panier(result, ad, orderEntity.getPrix(),date,orderEntity.getQuantite(), orderEntity.getPrix());
		}else {
			
		}
		
		
	}

	public Panier SearchCartByUser(String connectedAdherent) {
		
		return null;
	}

	public void addToCart(Resource idRessource, Long idPanier, String email) {
		
		
	}

}
