package data;

public class LowCountAlert {

	private String message;
	private int id;
	
	public LowCountAlert(String bookTitle, int id){
		
		setMessage("You have less than 50 copies of \"" + bookTitle + "\" (ID: " + id + ") in stock.");
		setId(id);
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
