package data;

public class Book {

	private int id;
	private String isbn;
	private int authorID;
	private String author;
	private String title;
	private int count;
	private double price;
	private int rating;
	
	
	public Book(String isbn, int authorID, String title, int count, double price){
		setIsbn(isbn);
		setAuthorID(authorID);
		setTitle(title);
		setCount(count);
		setPrice(price);
		setRating(0);
		
	}
	
	public Book(){
		
	};

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
