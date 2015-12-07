package jdbcLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import jdbcLayer.Mappers.BookRowMapper;
import jdbcLayer.Mappers.PurchaseRowMapper;
import jdbcLayer.Mappers.UserRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import data.LowCountAlert;
import data.Book;
import data.Purchase;
import data.User;

public class dbDAO {
	
private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getTemplate(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		return (JdbcTemplate)context.getBean("JdbcTemplate");
	}
	
	public void addToBookTable(Book newBook){
		
		String mysql = "INSERT INTO Book "
				+ "(bookID, title, authorID, inventoryCount, price, rating, isbn, genre) "
				+ "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		jdbcTemplate.update(mysql, new Object[] {newBook.getTitle(), 
				newBook.getAuthorID(), newBook.getCount(), newBook.getPrice(), 
				newBook.getRating(), newBook.getIsbn(), newBook.getGenre(), newBook.getWeight()});
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public Book getBookByID(int id){
		
		String mysql = "SELECT * FROM Book "
				+ "WHERE bookID = ?";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		Book newBook = (Book) jdbcTemplate.queryForObject(
				mysql, new Object[] {id}, new BookRowMapper());
		
		return newBook;
	}
	
	public void updateBookCount(int bookID, int count){
		
		String mysql = "UPDATE Book SET inventoryCount=? "
				+ "WHERE bookID = ?";

		JdbcTemplate jdbcTemplate = getTemplate();
		
		jdbcTemplate.update(mysql, new Object[] {count, bookID});
	}
	
	@SuppressWarnings({ "unchecked" })
	public User getUser(String username, String password){
		
		String mysql = "SELECT * FROM Users "
				+ "WHERE username = ? "
				+ "AND password = ?";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		User newUser = (User) jdbcTemplate.queryForObject(
				mysql, new Object[] {username, password}, new UserRowMapper());
		
		return newUser;
	}
	
	public void addUser(String username, String password){
		
		String mysql = "INSERT INTO Users " +
				"(uid, username, password) " + 
				"VALUES (NULL, ?, ?)";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		jdbcTemplate.update(mysql, username, password);
				
	}

	@SuppressWarnings("unchecked")
	public List<Book> getWarehouse(int uid) {
		
		
		String mysql = "SELECT * FROM Book "
				+ "WHERE uid = ?";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		List<Book> bookList = jdbcTemplate.query(
				mysql, new Object[] {uid}, new BookRowMapper());
		
		return bookList;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<LowCountAlert> lowBookCountAlerts(int uid) {
		
		
		String mysql = "SELECT * FROM Book "
				+ "WHERE uid = ? "
				+ "AND inventoryCount < 50";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		List<Book> bookList = jdbcTemplate.query(
				mysql, new Object[] {uid}, new BookRowMapper());
		
		ArrayList<LowCountAlert> alertList = new ArrayList<LowCountAlert>();
		
		for (int i = 0; i < bookList.size(); i++){
			alertList.add(new LowCountAlert(bookList.get(i).getTitle(), bookList.get(i).getId()));
		}
		
		return alertList;
		
	}
	
	public void addPurchase(Purchase newPurchase){
		
		String mysql = "INSERT INTO Purchase "
				+ "(purchaseID, date, total, bookID, shipmentID, userID, payPalID) "
				+ "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		jdbcTemplate.update(mysql, new Object[] {newPurchase.getSqlDate(), 
				newPurchase.getTotal(), newPurchase.getBookID(), 
				newPurchase.getShipmentID(), newPurchase.getUserID(),
				newPurchase.getPaypalID()});
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchases(int uid) {
		
		
		String mysql = "SELECT * FROM Purchase "
				+ "WHERE uid = ?";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		List<Purchase> purchaseList = jdbcTemplate.query(
				mysql, new Object[] {uid}, new PurchaseRowMapper());
		
		return purchaseList;
		
	}

}
