package data;

import java.sql.Date;

public class Purchase {
	
	
	private String date;
	private double total;
	private int userID;
	private int bookID;
	private int shipmentID;
	private String paypalID;
	
	
	
	
	public Purchase(String date, double total, int userID, int bookID, int shipmentID, String paypalID){
		setDate(date);
		setTotal(total);
		setUserID(userID);
		setBookID(bookID);
		setShipmentID(shipmentID);
		setPaypalID(paypalID);
	}


	public double getTotal() {
		return total;
	}




	public void setTotal(double total) {
		this.total = total;
	}




	public int getUserID() {
		return userID;
	}




	public void setUserID(int userID) {
		this.userID = userID;
	}




	public int getBookID() {
		return bookID;
	}




	public void setBookID(int bookID) {
		this.bookID = bookID;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}
	
	@SuppressWarnings("deprecation")
	public Date getSqlDate(){
		String[] splitDate = date.split("-");
		
		int month = Integer.parseInt(splitDate[0]) - 1;
		int day = Integer.parseInt(splitDate[1]);
		int year = Integer.parseInt(splitDate[2]) - 1990;
		
		Date theDate = new Date(year, month, day);
		
		return theDate;
	}


	public int getShipmentID() {
		return shipmentID;
	}


	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}


	public String getPaypalID() {
		return paypalID;
	}


	public void setPaypalID(String paypalID) {
		this.paypalID = paypalID;
	}
	
}
