package controllers;

import jdbcLayer.dbDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/login")
public class LoginController {
	
	dbDAO dao = new dbDAO();

	@RequestMapping(value = "/attempt", method = RequestMethod.POST,
			headers="Accept=application/json")
	public @ResponseBody String doLogin(@RequestParam String test) {
		return "Your param was: " + test;
	}

}