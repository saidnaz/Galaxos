package fr.isika.cda.galaxos.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Message")
@NamedQueries({
	@NamedQuery(name = "Message.findAll", query = "select m from Message m")
})
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Date", nullable = false)
	private LocalDateTime date;

	@Column(name = "Texte", nullable = false)
	private String texte;
	
	private int idDestinataire;
	
	private int idEmeteur;
	
	@OneToOne
	@JoinColumn(name = "fk_destinataire")
	private Adherent destinataire;

	@OneToOne
	@JoinColumn(name = "fk_expediteur")
	private Adherent expediteur;
	
	public LocalDateTime getDate() {
		return date;
	}

	public int getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(int idDestinataire) {
		this.idDestinataire = idDestinataire;
	}

	public int getIdEmeteur() {
		return idEmeteur;
	}

	public void setIdEmeteur(int idEmeteur) {
		this.idEmeteur = idEmeteur;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Long getId() {
		return id;
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
