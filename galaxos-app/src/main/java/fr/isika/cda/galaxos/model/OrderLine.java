package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.isika.cda.galaxos.model.resources.Resource;





@Entity
public class OrderLine implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 6066098580527022857L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int orderId;

	@ManyToOne
	@JoinColumn(name="FK_Command_ID")
	private Resource resource;

	private LocalDate dateLigneCommand;


	  public Resource getResource() { return resource; }

	  public void setResource(Resource resource) { this.resource = resource; }


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

	public OrderLine(Resource resource, LocalDate dateorderline, Double prix, Integer quantite) {
		super();
		this.resource =resource;
		this.dateLigneCommand = dateorderline;
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
