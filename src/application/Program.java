package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		while(checkOut.getTime() <= checkIn.getTime()) {
			System.out.print("Invalid date try again :");
			checkOut = sdf.parse(sc.next());
		}
		
		Reservation	reservation = new Reservation( roomNumber, checkIn, checkOut);
		
		System.out.println(reservation);
		System.out.println();
		
		System.out.println("Enter date to update the reservation: ");
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkInUpdate = sdf.parse(sc.next());
		while(checkInUpdate.getTime() <= checkIn.getTime()) {
			System.out.print("Invalid date try again :");
			checkInUpdate = sdf.parse(sc.next());
		}
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOutUpdate = sdf.parse(sc.next());
		while(checkOutUpdate.getTime() <= checkInUpdate.getTime()) {
			System.out.print("Invalid date try again :");
			checkOutUpdate = sdf.parse(sc.next());
		}
		
		reservation.updateDates(checkInUpdate, checkOutUpdate);
		System.out.println(reservation);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
