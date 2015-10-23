package controllers;

import jdbcLayer.dbDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.Book;

@RestController
@RequestMapping("/service/book")
public class BookController {
	
	dbDAO dao = new dbDAO();
	
	@RequestMapping(value = "/test", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody String test(@RequestParam String test) {
		return "Your param was: " + test;
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
			@RequestParam double price
			){
		
		try{
			Book newBook = new Book(isbn, authorID, title, count, price);
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
	public @ResponseBody HttpStatus updateBookCount(int bookID, int count){
		
		try{
			dao.updateBookCount(bookID, count);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
}
