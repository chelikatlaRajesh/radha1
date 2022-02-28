package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(method = RequestMethod.GET,value = "/hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello!This is Spring MVC APP";
	}
	
	@GetMapping("/")
	public String start()
	{
		return "index";
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		return "Welcome!!"+username;
	}
	
	
	
	
	
	
}
