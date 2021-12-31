package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Order_Line implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6066098580527022857L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int order_Id;
	
	@ManyToOne
	@JoinColumn(name="FK_Command_ID")
	Resource  resource;
	
	
	private LocalDate dateLigneCommand;
	 
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public LocalDate getDateorderline() {
		return dateLigneCommand;
	}

	public void setDateorderline(LocalDate dateorderline) {
		this.dateLigneCommand = dateorderline;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Order_Line(Resource resource, LocalDate dateorderline, Double prix, Integer quantité) {
		super();
		this.resource = resource;
		this.dateLigneCommand = dateorderline;
		this.prix = prix;
		this.quantité = quantité;
	}

	public Order_Line() {
		super();
	}
	
	public Integer getQuantité() {
		return quantité;
	}

	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	private Double prix;
	
	private Integer quantité;

}
