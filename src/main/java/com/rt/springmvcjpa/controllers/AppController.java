package com.rt.springmvcjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value="/indexPage", method=RequestMethod.GET)
	public String indexPage(){
		return "indexPage";
	}
	    
}
