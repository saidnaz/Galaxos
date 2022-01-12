package fr.isika.cda.galaxos.managedbeans;



import java.io.IOException;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

import fr.isika.cda.galaxos.model.ChargeRequest;
import fr.isika.cda.galaxos.service.PaymentService;


import fr.isika.cda.galaxos.managedbeans.PanierBean;

@Named
@RequestScoped
public class CheckoutBean {
    //Price/total
    //Currency
    //Public Stripe API key

   
    @Inject
    private ChargeRequest price;
    @Inject
    private PaymentService paymentService;
    
    private PanierBean panier;
  
    private String stripeToken;
    @Inject
    
    private String email;
    
    @PostConstruct
    private void init() throws StripeException{
        if (stripeToken != null && !stripeToken.isEmpty()) {

            createCharge();
        }
    }

////import com.stripe.model.Customer;//////methode permet de récupérer l'émail ConsumerStripe////////////////////////////////////////////////

    
    public String retrieveCustomer(String idCustomer) throws StripeException{
	
Stripe.apiKey =  "sk_test_51JmfnrBVeS0qA3DPjCdV4AhiUBUD9wrCSp1ucRH1FrbZWLCuM3Kk8Bn4D6TH0D1D4Xh30eOSw2dkNDcrwPSUhb6V00PmWgviMA";//SecretKey

Customer customer = Customer.retrieve(idCustomer);
return customer.getEmail();
}




//////////////////////////////////////////////////////////////////////////////////    
   





//
private void createCharge() throws StripeException {
    	
    	Stripe.apiKey =  "sk_test_51JmfnrBVeS0qA3DPjCdV4AhiUBUD9wrCSp1ucRH1FrbZWLCuM3Kk8Bn4D6TH0D1D4Xh30eOSw2dkNDcrwPSUhb6V00PmWgviMA";//SecretKey
    	 
        Charge charge = paymentService.charge(stripeToken, panier.getSommeDesAchats(), "euro");
    }
//		 if (charge != null) { "success?faces-redirect=true";
//		 }
//		 else {
//		 "failure?faces-redirect=true";
//		 
//		  } } catch (StripeException | IOException e) { 
//			  try {
//		  }
//		  return"failure?faces-redirect=true";
//		 
//
//        }

    
   

    public String getCurrency() {
       return null;
    }
    
    public String getKey(){
        return "pk_test_51JmfnrBVeS0qA3DPb06NvJY7QWo5qRe7zGcwJZLvAkthNao7udEmx90Skb9H07WcuyC2Y5UIFrfNvgKSMxL1xCNx00LCjUlLnJ";
    }
    
    
   

}
