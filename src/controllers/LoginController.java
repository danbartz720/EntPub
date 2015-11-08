package controllers;

import jdbcLayer.dbDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.User;

@RestController
@RequestMapping("/service/login")
public class LoginController {
	
	dbDAO dao = new dbDAO();

	@RequestMapping(value = "/attempt", method = RequestMethod.POST,
			headers="Accept=application/json")
	public @ResponseBody String doLogin(@RequestBody User loginUser) {
		
		User attempt = dao.getUser(loginUser.getUsername(), loginUser.getPassword());
		
		if (!(attempt == null)){
			return "User = " + loginUser.getUsername() + 
					"Pass = " + loginUser.getPassword() +
					"Uid = " + loginUser.getUid();
		} else {
			return "USER NOT FOUND!";
		}
	}
	
	@RequestMapping(value = "/attempt", method = RequestMethod.POST,
			headers="Accept=application/json")
	public @ResponseBody String newUser(@RequestBody User loginUser) {
		
		try {
			dao.addUser(loginUser.getUsername(), loginUser.getPassword());
			return "200";
		} catch (Exception e) {
			return "500";
		}
	}
}