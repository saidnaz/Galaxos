package fr.isika.cda.galaxos.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Dashboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "fkMessagerie")
	private Messagerie messagerie;

	public Long getId() {
		return id;
	}

	public Messagerie getMessagerie() {
		return messagerie;
	}

	public Dashboard() {
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, messagerie);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dashboard other = (Dashboard) obj;
		return Objects.equals(id, other.id) && Objects.equals(messagerie, other.messagerie);
	}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			
			builder.append("Profil [id=");
			builder.append(id);
			
			builder.append(", user=");
			builder.append(messagerie);
			
			builder.append("]");
			
			return builder.toString();
		}

}
