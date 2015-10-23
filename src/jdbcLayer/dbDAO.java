package jdbcLayer;

import javax.sql.DataSource;

import jdbcLayer.Mappers.BookRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import data.Book;

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
				+ "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
		
		JdbcTemplate jdbcTemplate = getTemplate();
		
		jdbcTemplate.update(mysql, new Object[] {newBook.getTitle(), 
				newBook.getAuthorID(), newBook.getCount(), newBook.getPrice(), 
				newBook.getRating(), newBook.getIsbn(), newBook.getGenre()});
		
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

}
