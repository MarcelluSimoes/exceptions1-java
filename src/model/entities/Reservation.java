package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer room, Date checkIn, Date checkOut) {
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
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	
	}
	
	@Override
	public String toString() {
		return "Room "
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
