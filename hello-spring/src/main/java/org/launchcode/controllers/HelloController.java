package org.launchcode.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest; // gets data from http requests (ie. headers, queries)

import org.launchcode.models.HelloLog;
import org.launchcode.models.dao.HelloLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // tell Spring this class as a controller (similar to component)
public class HelloController {
	
	@Autowired // injects instance of interface listed below
	private HelloLogDao helloLogDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm() {
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST) // tell Spring to use this method for all get requests to "/hello"
	// @ResponseBody // allows returning plain string (instead of a template)
	public String hello(HttpServletRequest request, Model model) {
		// get name parameter from request
		String name = request.getParameter("name");
		
		if (name == null || name == "") {
			name = "World";
		}
		
		HelloLog log = new HelloLog(name);
		helloLogDao.save(log); // saves log to db

		String language = request.getParameter("language");
		String hello;
		
		switch (language) {
			case "English": hello = "Hello";
			break;
			case "Dutch": hello = "Hallo";
			break;
			case "Czech": hello = "Ahoj";
			break;
			case "French": hello = "Salut";
			break;
			default: hello = "Hello";
			break;
		}
			
		model.addAttribute("name", name); // make "message" variable, give it the value of HelloMessage.getMessage(name), and pass it into thymeleaf template as dictated below
		model.addAttribute("title", "Hello, Spring! Response");
		model.addAttribute("hello", hello);
		return "hello"; // name of template file without .html (if in different folder list as folder/hello)
	}
	
	@RequestMapping(value = "/log")
	public String log(Model model) {
		
		//get data out of db
		List<HelloLog> logs = helloLogDao.findAll();
		
		//put db into template
		model.addAttribute("logs", logs);
		
		return"log";
	}
	
}
