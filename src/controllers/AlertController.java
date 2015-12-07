package controllers;

import java.util.ArrayList;
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

import data.LowCountAlert;
import data.Book;
import data.User;

@RestController
@RequestMapping("/service/alerts")
public class AlertController {
	
	dbDAO dao = new dbDAO();

	@RequestMapping(value = "/getAlerts", method = RequestMethod.GET,
			headers="Accept=application/json")
	public @ResponseBody ArrayList<LowCountAlert> getAlerts(@RequestParam int uid) {
		
		ArrayList<LowCountAlert> alertsList = new ArrayList<LowCountAlert>();
		
		alertsList = dao.lowBookCountAlerts(uid);
		
		return alertsList;
		
	}
}