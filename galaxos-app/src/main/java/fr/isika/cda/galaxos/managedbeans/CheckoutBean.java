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

   
  
    private PanierBean panier;
  
    private String stripeToken;
    
    private  BigDecimal total;
    private String email;
    
    
    
    @Inject
    private ChargeRequest price;
    public PanierBean getPanier() {
		return panier;
	}

	public void setPanier(PanierBean panier) {
		this.panier = panier;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Inject
    private PaymentService paymentService;
    
    
    @PostConstruct
    private void init() throws StripeException{
        if (stripeToken != null && !stripeToken.isEmpty()) {

            createCharge();
            total = panier.getSommeDesAchats();
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
    	 
        Charge charge = paymentService.charge(stripeToken, total, "euro");
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
