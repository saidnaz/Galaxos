package fr.isika.cda.galaxos.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Date", nullable = false)
	private LocalDateTime date;

	@Column(name = "Texte", nullable = false)
	private String texte;
	
	

	@OneToOne
	@JoinColumn(name = "fk_destinataire")
	private Adherent destinataire;

	@OneToOne
	@JoinColumn(name = "fk_expediteur")
	private Adherent expediteur;



	
	public Long getIdMessage() {
		return id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Adherent getDestinataire() {
		return destinataire;
	}

	public Adherent getExpediteur() {
		return expediteur;
	}

	public LocalDateTime getDate() {
		return date;
	}

	
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Message [id=");
		builder.append(id);
		
		builder.append(", date=");
		builder.append(date);
		
		builder.append(", texte=");
		builder.append(texte);
		
		builder.append("]");
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id) && Objects.equals(date, other.date);
	}

	public Message() {
	}

	
	
	
}
