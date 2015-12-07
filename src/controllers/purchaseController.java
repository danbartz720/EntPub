package controllers;

import java.util.List;

import jdbcLayer.dbDAO;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.Book;
import data.Purchase;
import data.StringHolder;
import data.User;

@RestController
@RequestMapping("/service/transaction")
public class purchaseController {
	
	dbDAO dao = new dbDAO();

	@RequestMapping(value = "/newPurchase", method = RequestMethod.POST,
			headers="Accept=application/json")
	public @ResponseBody HttpStatus newPurchase(@RequestBody Purchase purchase, Model model) {
		
		try{
			dao.addPurchase(purchase);
		} catch (Exception e){
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}
	
	@RequestMapping(value = "/getPurchases", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody List<Purchase> getPurchases(@RequestParam int uid) {
		List<Purchase> purchases = dao.getPurchases(uid);
		return purchases;
	}
	
}