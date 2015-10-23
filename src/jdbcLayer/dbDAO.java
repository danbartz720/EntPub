package jdbcLayer;

import javax.sql.DataSource;

import jdbcLayer.Mappers.BookRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import data.Book;

public class dbDAO {
	
	JdbcTemplate jdbcTemplate;
private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addToBookTable(Book newBook){
		
		String mysql = "INSERT INTO Book "
				+ "(bookID, title, authorID, inventoryCount, price, rating, isbn) "
				+ "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
		
		//jdbcTemplate = new JdbcTemplate(dataSource);
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("JdbcTemplate");
		
		jdbcTemplate.update(mysql, new Object[] {newBook.getTitle(), 
				newBook.getAuthorID(), newBook.getCount(), newBook.getPrice(), 
				newBook.getRating(), newBook.getIsbn()});
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public Book getBookByID(int id){
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("JdbcTemplate");
		
		String mysql = "SELECT * FROM Book "
				+ "WHERE bookID = ?";
		
		Book newBook = (Book) jdbcTemplate.queryForObject(
				mysql, new Object[] {id}, new BookRowMapper());
		
		return newBook;
	}
	
	public void updateBookCount(int bookID, int count){
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("JdbcTemplate");
		
		String mysql = "UPDATE Book SET inventoryCount=? "
				+ "WHERE bookID = ?";
		
		jdbcTemplate.update(mysql, new Object[] {count, bookID});
	}

}
