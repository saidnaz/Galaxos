package fr.isika.cda.galaxos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChargeRequest {
	
	public ChargeRequest() {
		super();
		
	}
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	

		   public enum Currency {
		     USD, EUR;
		 }
		    private String Description;
		    private int Amount;
		    private Currency Currency;
		   
		    private String StripeToken;
			public String getDescription() {
				return Description;
			}
			
			///////////////////////////////////////////////Getters and Setters//////////////////////////////////////
			public void setDescription(String description) {
				Description = description;
			}
			public int getAmount() {
				return Amount;
			}
			public void setAmount(int amount) {
				Amount = amount;
			}
			public Currency getCurrency() {
				return Currency;
			}
			public void setCurrency(Currency currency) {
				Currency = currency;
			}

			public String getStripeToken() {
				return StripeToken;
			}
			public void setStripeToken(String stripeToken) {
				StripeToken = stripeToken;
			}
		}


