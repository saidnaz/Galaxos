package fr.isika.cda.galaxos.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LocationAddForm extends ResourceAddForm implements Serializable{

	private static final long serialVersionUID = 1986891338347461072L;
	
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	public LocationAddForm() {
	}
	
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
