package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		//ATIVIDADE - SEGUNDA SOLUÇÃO PARA O TRATAMENTO DE EXCEÇÕES, SOLUÇÃO RUIM
			//TODOS OS TRATAMENTOS DE EXCEÇÕES SERÃO PASSADOS PARA A CLASSE "RESERVA", MAS, EM MÉTODOS
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date: ");
		Date checkIn = formato.parse(sc.next());
		System.out.print("Check-out date: ");
		Date checkOut = formato.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date: ");
			checkIn = formato.parse(sc.next());
			System.out.print("Check-out date: ");
			checkOut = formato.parse(sc.next());
				
			String error = reservation.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println(error);
			} else {
				System.out.println("Reservation: " + reservation.toString());
			}
		
		}
		
		
		
		
		sc.close();
	}
}
