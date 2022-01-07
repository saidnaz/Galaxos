package fr.isika.cda.galaxos.app;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<LocalDate> lReservation = new ArrayList<>();	// Attribut dans le Model
		List<LocalDate> lDispoDebut = new ArrayList<>();		// Attribut dans le viewModel (DTO)
		List<LocalDate> lDispoFin = new ArrayList<>();	
		LocalDate dateDebutTentative;					// Attribut temporaire dans une méthode reservation qui comprend 2 méthodes !
		
		reservationTest(lReservation, lDispoDebut, 2022, 2, 15, 2022, 2, 25);
		System.out.println(lReservation.toString());
		
		afficherDatesDispo(lReservation, lDispoDebut, 2022, 2);
		System.out.println(lDispoDebut.toString());
		
		reservationTest(lReservation, lDispoDebut, 2022, 2, 14, 2022, 2, 26);
		System.out.println(lReservation.toString());
		
		
	}

	// Le client choisi 1 date de debut et une date de fin de location
	public static void reservationTest(List<LocalDate> lreservation, List<LocalDate> ldispo, int annee1, int mois1, int jour1, int annee2, int mois2, int jour2) {
//	public static void reservation(List<LocalDate> lreservation, Date debut, Date fin) {
		
		LocalDate debut = LocalDate.of(annee1, mois1, jour1);
		LocalDate fin = LocalDate.of(annee2, mois2, jour2);
		
		// condition ici pour dire qu'il n'a pas le droit de louer si c'est déjà pris.
		for (int i = 0; i < lreservation.size(); i+=2)
		{
			if (!lreservation.get(i).isBefore(debut) && !lreservation.get(i).isAfter(fin))	// Càd que la condition est validé si une date occupé est comprise dans les dates de location souhaitées
			{
				System.out.println("Des dates sont indisponibles à la location dans l'intervalle de dates selectionnées, veuillez selectionner des dates valides");
				return;
			}
		}
		
		lreservation.add(debut);
		lreservation.add(fin);
		
		// Décomposer plutot la méthode reservation en : choisir dateDebut et choisirDateFin :
		// Comme ça après avoir choisi une date début, les dates affichées sont actualisées pour que le client voit uniquement les dates de fin de location possible.
		// Voir Reservation !
	}
	
	
	
	public static void reservation(List<LocalDate> lreservation, List<LocalDate> ldispodebut, List<LocalDate> ldispofin, int annee1, int mois1, int jour1, int annee2, int mois2, int jour2)
	{
//	public static void reservation(List<LocalDate> lreservation, Date debut, Date fin) {
	
		LocalDate debut = LocalDate.of(annee1, mois1, jour1);
		LocalDate fin = LocalDate.of(annee2, mois2, jour2);
		
		reservationDebut(lreservation, ldispodebut, annee1, mois1, jour1);
		reservationFin(debut, lreservation, ldispofin, annee1, mois1, jour1);
	}
	
	public static void reservationDebut(List<LocalDate> lreservation, List<LocalDate> ldispodebut, int annee1, int mois1, int jour1)
	{
		LocalDate debut = LocalDate.of(annee1, mois1, jour1);
	//	Peut uniquement selectionner des dates disponibles à l'ecran, donc pas besoin de mettre des conditions pour voir si la dateDebut est bien dispo
		lreservation.add(debut);
	}
	
	public static void reservationFin(LocalDate debut, List<LocalDate> lreservation, List<LocalDate> ldispo, int annee2, int mois2, int jour2)
	{
		LocalDate fin = LocalDate.of(annee2, mois2, jour2);
		
		for (int i = 0; i < lreservation.size(); i+=2)
		{
			if (!lreservation.get(i).isBefore(debut) && !lreservation.get(i).isAfter(fin))	// Càd que la condition est validé si une date occupé est comprise dans les dates de location souhaitées
			{
				System.out.println("Des dates sont indisponibles à la location dans l'intervalle de dates selectionnées, veuillez selectionner des dates valides");
				return;
			}
		}
		
		lreservation.add(fin);
	}
	
	
	
	public static void afficherDatesDispo(List<LocalDate> lreservation, List<LocalDate> ldispo, int annee, int mois)
	{
		LocalDate date = LocalDate.of(annee, mois, 1);
		int nbreJours = date.lengthOfMonth();
		
	//	List<LocalDate> lDispo = new ArrayList<>();

//		int month = localDate.getMonthValue();
//		int dayOfMonth = localDate.getDayOfMonth();
		
		// faire un contains de la liste pour les dates du mois
		for (int i = 0; i<nbreJours; i++)
		{
		//	LocalDate dateCompare = date.withDayOfMonth(i+1);
			
			for (int n = 0; n < lreservation.size(); n+=2)
			{
				if(date.withDayOfMonth(i+1).isBefore(lreservation.get(n)) || date.withDayOfMonth(i+1).isAfter(lreservation.get(n+1)))
			//	if(dateCompare.isBefore(lreservation.get(n)) || dateCompare.isAfter(lreservation.get(n+1)))
				{
					ldispo.add(date.withDayOfMonth(i+1));
				}
			}
		}
		
	}
	
	// Cours
	public void exemplesMethodesLocalDate() {

		LocalDate localDate = LocalDate.of(2019, 06, 15);
		LocalDate day = localDate.with(TemporalAdjusters.firstDayOfMonth());
		day = localDate.with(TemporalAdjusters.lastDayOfMonth());
		day = localDate.with(TemporalAdjusters.firstDayOfNextMonth());


		LocalDate initial = LocalDate.of(2014, 2, 13);
		LocalDate dateFirstDay = initial.withDayOfMonth(1);
		LocalDate dateLastDay = initial.withDayOfMonth(initial.lengthOfMonth());

		
		LocalDate nineApr = LocalDate.parse("2019-04-09");
		LocalDate fourApr = LocalDate.parse("2019-04-04");
		
		boolean isBefore = nineApr.isBefore(fourApr);
		boolean isAfter = nineApr.isAfter(fourApr);
		boolean isEqual = nineApr.isEqual(LocalDate.of(2019, 4, 9));

		
	
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.YEAR, 2021);
		Calendar newCalendar = cal;
		
		Date dateCompare = new Date(nineApr.getYear(),nineApr.getMonthValue(),1);
	}
	
	// méthode déjà existante en java ... -> localDate1.isEquals(localDate2) ...
	public static boolean compareDate(LocalDate date1, LocalDate date2) {
		int annee1 = date1.getYear();
		int mois1 = date1.getMonthValue();
		int jour1 = date1.getDayOfMonth();

		int annee2 = date2.getYear();
		int mois2 = date2.getMonthValue();
		int jour2 = date2.getDayOfMonth();

		if (annee1 == annee2 && mois1 == mois2 && jour1 == jour2) {
			return true;
		} else
			return false;
		
	}

}
