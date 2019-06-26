package com.rt.springmvcjpa.exceptionControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for error pages requests
 * 
 * @author ykarav
 *
 */
@Controller
@RequestMapping("/errors")
public class SpringExceptionsController {
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFoundPage() {
        return "standardSpringExceptions/404";
    }
	
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String internalServerErrorPage(Exception ex){
		return "redirect:/errors/500";
	}

}
