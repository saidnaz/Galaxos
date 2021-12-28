package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Panier(List<Order_Line> orderlines, Consumer consumer, LocalDate datePanier, PaymentType typePaiement,
			Double prixTotal, boolean isValid, Integer quantiteTotale) {
		super();
		this.orderlines = orderlines;
		this.consumer = consumer;
		this.datePanier = datePanier;
		this.typePaiement = typePaiement;
		this.prixTotal = prixTotal;
		this.isValid = isValid;
		this.quantiteTotale = quantiteTotale;
	}

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", orderlines=" + orderlines + ", consumer=" + consumer
				+ ", datePanier=" + datePanier + ", typePaiement=" + typePaiement + ", prixTotal=" + prixTotal
				+ ", isValid=" + isValid + ", quantiteTotale=" + quantiteTotale + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPanier;
	
	@OneToMany(cascade = CascadeType.REMOVE,
			fetch=FetchType.EAGER)
	private List<Order_Line> orderlines ;
	
	@ManyToOne
	@JoinColumn(name="FK_CONSUMER_ID")
	Consumer consumer;
	
	public List<Order_Line> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Order_Line> orderlines) {
		this.orderlines = orderlines;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public LocalDate getDatePanier() {
		return datePanier;
	}

	public void setDatePanier(LocalDate datePanier) {
		this.datePanier = datePanier;
	}

	public PaymentType getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(PaymentType typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Integer getQuantiteTotale() {
		return quantiteTotale;
	}

	public void setQuantiteTotale(Integer quantiteTotale) {
		this.quantiteTotale = quantiteTotale;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdPanier() {
		return idPanier;
	}

	@Temporal(TemporalType.DATE)
	private LocalDate datePanier;
	
	
	
	@Enumerated(EnumType.STRING)
	private PaymentType typePaiement;

	private Double prixTotal;
	private boolean isValid;

	private Integer quantiteTotale;
	

}
