package fr.isika.cda.galaxos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


//	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@Column(name = "Date")
	private LocalDateTime dateType;
	
	@Column(name = "DateString")
	private String date;

	@Column(name = "Texte", nullable = false)
	private String texte;
	
	@OneToOne
	@JoinColumn(name = "fk_destinataire")
	private Adherent destinataire;

	@OneToOne
	@JoinColumn(name = "fk_expediteur")
	private Adherent expediteur;
	
	public LocalDateTime getDate() {
		return dateType;
	}

	public void setDate(LocalDateTime datetype) {
		this.dateType = datetype;
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

	public Adherent getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Adherent destinataire) {
		this.destinataire = destinataire;
	}

	public Adherent getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Adherent expediteur) {
		this.expediteur = expediteur;
	}

	public String getDateString() {
		return date;
	}

	public void setDateString(String dateString) {
		this.date = dateString;
	}

	public void addDate()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		
		LocalDateTime dateNow = LocalDateTime.now();
		String str = dateNow.format(formatter);
		
		this.dateType = dateNow;
		this.date = str.replace(":","h");
		
	//	LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
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
		
		addDate();
		
	}

	
	public Message(String texte, Adherent expediteur,Adherent destinataire, String dateDisplay) {
		super();
		this.texte = texte;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		LocalDateTime dateType = LocalDateTime.parse(dateDisplay, formatter);
		
		this.dateType = dateType;
		this.date = dateDisplay.replace(":", "h");
		
	}


	

	
	
	
}
