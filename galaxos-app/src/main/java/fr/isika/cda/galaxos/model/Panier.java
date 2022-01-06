package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import fr.isika.cda.galaxos.model.roles.Consumer;
import jdk.jfr.Timestamp;

@Entity
public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPanier;
	
	@Transient
	@ManyToOne
	@JoinColumn(name="FK_PR_ID")
	Resource  resource;
	
	@Timestamp
    private LocalDate datePanier;
    private Double prixTotal;
	private boolean isValid;
    private Integer quantiteTotale;
    
    @Enumerated(EnumType.STRING)
	private TypePay typePaiement;
	
	
	public TypePay getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(TypePay typePaiement) {
		this.typePaiement = typePaiement;
	}

	@OneToMany(cascade = CascadeType.REMOVE,
			fetch=FetchType.EAGER)
	private List<OrderLine> orderlines ;
	
	@ManyToOne
	@JoinColumn(name="FK_CONSUMER_ID")
	Consumer consumer;
	
	public Panier(List<OrderLine> orderlines, Consumer consumer, LocalDate datePanier, TypePay typePaiement,
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

	
	
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
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

	
	

}
