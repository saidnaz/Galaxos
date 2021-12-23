package fr.isika.cda.galaxos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="associations")
public class Association {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		private String associationName;
		
		private int rnaNumber;
		
		//private Adresse address;
		
		private String email;
		
		private String password;
		
		private String description;
		
		private int phone;
		

		
		@Column(nullable=false)
		private String logo;
		
		 @OneToMany(mappedBy ="association")
		 private List<Adherent> adherents;
		 


		public Association() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getAssociationName() {
			return associationName;
		}

		public void setAssociationName(String associationName) {
			this.associationName = associationName;
		}

		public int getRnaNumber() {
			return rnaNumber;
		}

		public void setRnaNumber(int rnaNumber) {
			this.rnaNumber = rnaNumber;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getPhone() {
			return phone;
		}

		public void setPhone(int phone) {
			this.phone = phone;
		}


		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		public List<Adherent> getAdherents() {
			return adherents;
		}

		public void setAdherents(List<Adherent> adherents) {
			this.adherents = adherents;
		}

		public Long getId() {
			return id;
		}
		 
		 
		 
		 
}
