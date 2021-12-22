package fr.isika.cda.galaxos.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMessage;

	@Column(name = "Date", nullable = false)
	private LocalDateTime date;

	@Column(name = "Message", nullable = false)
	private String message;

	@OneToOne
	@Column(name = "Destinataire", nullable = false)
	@JoinColumn(name = fk_destinataire)
	private Adherent destinataire;

	@OneToOne
	@Column(name = "Expediteur", nullable = false)
	@JoinColumn(name = fk_expediteur)
	private Adherent expediteur;

	
	public Long getIdMessage() {
		return idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "Message [idMessage=" + idMessage + ", date=" + date + ", message=" + message + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMessage);
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
		return Objects.equals(idMessage, other.idMessage);
	}

	public Message() {
		super();
	}

	
	
	
}
