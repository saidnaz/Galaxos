package fr.isika.cda.galaxos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    private Note note;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Provider provider;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Post post;

	    public Avis() {

	    }
	    

}
