package fr.isika.cda.galaxos.model;



import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Avis{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    private Note note;
	    
	    @Column(length = 600,name="Avis")
	    private String Texte;

//	    @ManyToOne(fetch = FetchType.EAGER)
//	    private Provider provider;
//	    
//	    @ManyToOne(fetch = FetchType.EAGER)
//	    private Consumer consumer;
	    
	    
	    @OneToOne
	    @JoinColumn(name="fkprovider")
	    private Provider provider;
	    
	    @OneToOne
	    @JoinColumn(name="fkconsumer")
	    private Consumer consumer;
	    
	    
//	    @ManyToOne(fetch = FetchType.EAGER)
//	    private Post post;

	    @Column(name = "Date", nullable = false)
		private LocalDateTime date;
	    
	    
	    //Constructeur vide
	    
	    public Avis() {

	    }

	    //GET & SET
	    
		public Note getNote() {
			return note;
		}

		public void setNote(Note note) {
			this.note = note;
		}

		public String getTexte() {
			return Texte;
		}

		public void setTexte(String texte) {
			Texte = texte;
		}

		public Long getId() {
			return id;
		}

		public Provider getProvider() {
			return provider;
		}

		public Consumer getConsumer() {
			return consumer;
		}

		public LocalDateTime getDate() {
			return date;
		}

		//Ajouter consumer 
		
		@Override
		public int hashCode() {
			return Objects.hash(id, provider);
		}
		
		//Ajouter consumer 

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Avis other = (Avis) obj;
			return Objects.equals(id, other.id) && Objects.equals(provider, other.provider);
		}

		public Avis(Long id, Note note, String texte, Provider provider, Consumer consumer, LocalDateTime date) {
			super();
			this.id = id;
			this.note = note;
			Texte = texte;
			this.provider = provider;
			this.consumer = consumer;
			this.date = date;
		}
	    
	    
	    

}
