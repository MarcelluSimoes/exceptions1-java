package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer room, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn) ) { // tratamento para datas futuras porem trocadas
			throw new DomainException("Check-out date must be after check-in date") ;
		}
		
		this.roomNumber = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoom() {
		return roomNumber;
	}

	public void setRoom(Integer room) {
		this.roomNumber = room;
	}
	
	public Date getCheckin() {
		return checkIn;
	}
	

	public Date getCheckout() {
		return checkOut;
	}

	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date(); // tratamento para nao fazer reservas para datas passadas 
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException(" Reservation dates for update must be future dates") ;
		}
		if(!checkOut.after(checkIn) ) { // tratamento para datas futuras porem trocadas
			throw new DomainException("Check-out date must be after check-in date") ;
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return " Room "
				+ roomNumber
				+ ", " 
				+ "check-in: "
				+ sdf.format(checkIn)
				+ ", "
				+ "check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths";
				
	}
	
}
