package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		//ATIVIDADE - TERCEIRA SOLUÇÃO PARA O TRATAMENTO DE EXCEÇÕES, SOLUÇÃO BOA
			//O TRATAMENTO DAS EXCEÇÕES É FEITO NO MÉTODO QUE PODE OCASIONA-LAS, UTILIANDO DOS BLOCO DE EXCEÇÃO
		
	Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date: ");
			Date checkIn = formato.parse(sc.next());
			System.out.print("Check-out date: ");
			Date checkOut = formato.parse(sc.next());
			
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date: ");
			checkIn = formato.parse(sc.next());
			System.out.print("Check-out date: ");
			checkOut = formato.parse(sc.next());
				
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			//captura da exceção que foi propagada pela classe
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
	sc.close();
	}
}
