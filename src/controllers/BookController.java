package controllers;

import java.util.ArrayList;
import java.util.List;

import jdbcLayer.dbDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.Book;
import data.StringHolder;

@RestController
@RequestMapping("/service/book")
public class BookController {
	
	dbDAO dao = new dbDAO();
	
	@RequestMapping(value = "/test", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody StringHolder test(@RequestParam String test) {
		StringHolder temp = new StringHolder("Your param was: " + test);
		return temp;
	}
	
	@RequestMapping(value = "/warehouse", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody List<Book> getWarehouse(@RequestParam int uid) {
		List<Book> warehouse = dao.getWarehouse(uid);
		return warehouse;
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody Book getBook(@RequestParam int bookID) {

		
		Book tempBook = dao.getBookByID(bookID);
		
		return tempBook;

	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody String addBook(
			@RequestParam String isbn,
			@RequestParam int authorID,
			@RequestParam String title,
			@RequestParam int count,
			@RequestParam double price,
			@RequestParam String genre,
			@RequestParam Double weight
			){
		
		try{
			Book newBook = new Book(isbn, authorID, title, count, price, genre, weight);
			dao.addToBookTable(newBook);
			return "OK";
		} catch (Exception e) {
			StackTraceElement[] trace = e.getStackTrace();
			String traceOut = e.getMessage() + "\n\n";
			for(int i = 0; i < trace.length; i++){
				traceOut += trace[i].toString() + "\n";
			}
			return traceOut;
		}
	}
	
	@RequestMapping(value = "/updateCount", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody StringHolder updateBookCount(
			@RequestParam int bookID, 
			@RequestParam int count){
		
		try{
			dao.updateBookCount(bookID, count);
			return new StringHolder(HttpStatus.OK.toString());
		} catch (Exception e) {
			return new StringHolder(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}
	
}
