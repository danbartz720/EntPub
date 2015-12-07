package data;

public class Book {

	private int bookId;
	private String isbn;
	private int authorID;
	private String author;
	private String title;
	private int inventoryCount;
	private double price;
	private int rating;
	private String genre;
	private Double weight;
	
	
	public Book(String isbn, int authorID, String title, int count, double price, String genre, Double weight){
		setIsbn(isbn);
		setAuthorID(authorID);
		setTitle(title);
		setCount(count);
		setPrice(price);
		setRating(0);
		setGenre(genre);
		setWeight(weight);
		
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
		return inventoryCount;
	}

	public void setCount(int count) {
		this.inventoryCount = count;
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
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return bookId;
	}

	public void setId(int id) {
		this.bookId = id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
}
