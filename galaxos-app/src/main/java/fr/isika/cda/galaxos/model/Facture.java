package fr.isika.cda.galaxos.model;

	import java.io.Serializable;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToOne;

	@Entity
	public class Facture implements Serializable{

		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int idFacture;
		
		
		@OneToOne(cascade = CascadeType.REMOVE)
		private Panier panierDetail;


		public Facture() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Facture(Panier panierDetail) {
			super();
			this.panierDetail = panierDetail;
		}


		@Override
		public String toString() {
			return "Facture [idFacture=" + idFacture + ", panierDetail=" + panierDetail + "]";
		}
		
		

}
