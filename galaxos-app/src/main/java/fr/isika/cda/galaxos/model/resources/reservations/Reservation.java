package fr.isika.cda.galaxos.model.resources.reservations;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idReservation;
	
	private LocalDateTime dateDebut;
	
	private LocalDateTime dateFin;

	public Reservation() {}

	public Reservation(Long idReservation, LocalDateTime dateDebut, LocalDateTime dateFin) {
		this.idReservation = idReservation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdReservation() {
		return idReservation;
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
