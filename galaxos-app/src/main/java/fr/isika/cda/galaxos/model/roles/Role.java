package fr.isika.cda.galaxos.model.roles;

import java.util.Objects;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Adherent;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn()
	private Adherent adherent;
	
	public Role() {}
	
	public Role(Long id, Adherent adherent) {
		super();
		this.id = id;
		this.adherent = adherent;
	}

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adherent, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(adherent, other.adherent) && Objects.equals(id, other.id);
	}

}
