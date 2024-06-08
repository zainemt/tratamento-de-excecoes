package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//declara uma formatação padrão para a data - define-o como static, já que não é necessário a criação de uma nova instância para cada objeto 
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//cálculo da diferença entre duas datas
		long diff = checkOut.getTime() - checkIn.getTime();
			//retorna a diferença entre as duas datas EM MILISEGUNDOS
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date newCheckIn, Date newCheckOut) {
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.checkIn =  newCheckIn;
		this.checkOut  = newCheckOut;
	}
	
	@Override
	public String toString() {
		return "Room: " + roomNumber 
				+ ", Check-in: " + formato.format(checkIn) 
				+ ", Check-out: " + formato.format(checkOut)
				+ ", " + duration() + " nights."; 
	}

	
}
