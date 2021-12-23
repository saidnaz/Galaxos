package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Messagerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "fkMessage")
	private Message message;

	public Long getId() {
		return id;
	}

	public Message getMessage() {
		return message;
	}

	public Messagerie() {
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, message);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messagerie other = (Messagerie) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message);
	}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			
			builder.append("Profil [id=");
			builder.append(id);
			
			builder.append(", user=");
			builder.append(message);
			
			builder.append("]");
			
			return builder.toString();
		}
	
	

}
