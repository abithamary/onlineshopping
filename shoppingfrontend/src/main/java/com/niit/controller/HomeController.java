package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController 
{
	
	@RequestMapping("/")
	public ModelAndView HomePage()
	{
		
		ModelAndView mv=new ModelAndView("index");
		
		mv.addObject("greeting","Welcome to Learn Spring MVC");
		return mv;
		
		
	}

	@RequestMapping("/about")
	public ModelAndView AboutPage()
	{
		
		ModelAndView mv=new ModelAndView("about");
		
		mv.addObject("greeting","Welcome to about page");
		return mv;
		
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView ContactPage()
	{
		
		ModelAndView mv=new ModelAndView("contact");
		
		mv.addObject("greeting","Welcome to Contact page");
		return mv;
		
		
	}
	
}
