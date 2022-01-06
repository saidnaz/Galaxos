package fr.isika.cda.galaxos.model.roles;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="providers")
@PrimaryKeyJoinColumn(name="id")
public class Provider extends Client{
	
	private Double note;
	
	public Provider() {}
	
	public Provider(Double note) {
		super();
		this.note = note;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}
	
	
}
