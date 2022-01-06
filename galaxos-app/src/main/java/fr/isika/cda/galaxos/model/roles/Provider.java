package fr.isika.cda.galaxos.model.roles;


import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.Adherent;
import fr.isika.cda.galaxos.model.Association;
import fr.isika.cda.galaxos.model.Note;
import fr.isika.cda.galaxos.model.Post;

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
