package jdbcLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import data.Book;

@SuppressWarnings("rawtypes")
public class BookRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book newBook = new Book();
            newBook.setId(rs.getInt("bookID"));
            newBook.setTitle(rs.getString("Title"));
            newBook.setAuthorID(rs.getInt("authorID"));
            newBook.setCount(rs.getInt("inventoryCount"));
            newBook.setPrice(rs.getDouble("price"));
            newBook.setRating(rs.getInt("rating"));
            newBook.setIsbn(rs.getString("isbn"));
            return newBook;
        }
}