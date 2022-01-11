package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//@Entity
public class OrderLine implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 6066098580527022857L;

	//@Id
	//@GeneratedValue (strategy = GenerationType.AUTO)
	private Long orderId;

	
	private String resourceName;
	
	private Double totale;

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	


	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public OrderLine(Double prix, Integer quantite) {
		super();
				
		this.prix = prix;
		this.quantite = quantite;
	}


	public OrderLine(String resource, Double prix, Integer quantite) {
		super();
		this.resourceName = resource;		
		this.prix = prix;
		this.quantite = quantite;
	}

	public OrderLine() {
		super();
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantité(Integer quantite) {
		this.quantite = quantite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOrderId() {
		return getOrderId();
	}

	private Double prix;

	private Integer quantite;

}
