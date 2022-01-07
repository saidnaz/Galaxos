package fr.isika.cda.galaxos.model.resources.reservations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class GestionnaireResa {

	@Id 
	@Column(name="id_gestion_resa") 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long idGestRes;
	
	@OneToMany
	private List<Reservation> fkReservations = new ArrayList<Reservation>();

	public GestionnaireResa() {}

	public GestionnaireResa(Long idGestRes, List<Reservation> fkReservations) {
		super();
		this.idGestRes = idGestRes;
		this.fkReservations = fkReservations;
	}

	public Long getIdGestRes() {
		return idGestRes;
	}

	public List<Reservation> getFkReservation() {
		return fkReservations;
	}

	public void addFkReservation(Reservation fkReservation) {
		this.fkReservations.add(fkReservation);
	}
	
	public void removeFkReservation(Reservation fkReservation) {
		this.fkReservations.remove(fkReservation);
	}
}
