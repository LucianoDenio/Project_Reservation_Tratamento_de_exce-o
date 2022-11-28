package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainExceptions("Check-out date must be after Check-in date ");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer  getRoomNumber() {
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

	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) { // o before testa se uma data é antes de outra.
			throw new DomainExceptions("Reservation dates for update must be future dates ");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainExceptions("Check-out date must be after Check-in date ");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public long duration() { // O metodo long é o maior da Biblioteca Java ideal para milesegundos.
		long diff = checkOut.getTime() - checkIn.getTime(); // o getTime() pega o tempo em Milisegundos .
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Usando uma classe Enumerado essa operação converte Millesegundos para dias.
	}
	
	@Override
	public String toString() {
		return "Room " 
			+ roomNumber
			+ ", check-in: "
			+sdf.format(checkIn)
			+", check-out: "
			+sdf.format(checkOut)
			+", "
			+duration()
			+" nigths";
	}
	
	
	
	
	
	
}
