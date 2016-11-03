package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest; // gets data from http requests (ie. headers, queries)

import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // tell Spring this class as a controller (similar to component)
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET) // tell Spring to use this method for all get requests to "/hello"
	@ResponseBody // allows returning plain string (instead of a template)
	public String hello(HttpServletRequest request) {
		// get name parameter from request
		String name = request.getParameter("name");
		
		if (name == null) {
			name = "World";
		}
		
		return "<h1>" + HelloMessage.getMessage(name) + "</h1>";
	}
	
}
