package com.niit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {

	
	@RequestMapping("/")
	public String showpage()
	{
		//System.out.println("in index page");
		return "index";
		
	}
			
	@RequestMapping("/login")
	public String showLogin()
	{
				
		return "login";
	}

	@RequestMapping("/Register")
	public String showRegister()
	{
		return "Register";
	}
	@RequestMapping("/contact")
	public String showcontact()
	{
		return "contact";
	}
	@RequestMapping("/AboutUs")
	public String showabout()
	{
		return "AboutUs";
	}

	
}
