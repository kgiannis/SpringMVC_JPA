package com.rt.springmvcjpa.exceptionControllers;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Controller for Standard Spring Exceptions
 * 
 * @author ykarav
 *
 */
@ControllerAdvice
public class StandardSpringExceptionsController {
	
	/**
	 * For a full list of standard exceptions visit:
	 * http://docs.spring.io/spring/docs/4.0.4.RELEASE/spring-framework-reference/htmlsingle/#mvc-exceptionhandlers
	 */

	
	@ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFound(Exception ex) {
        return "redirect:/errors/404";
    }
	
	@ExceptionHandler(ConversionNotSupportedException.class)
	public String handleConversionNotSupportedException(Exception ex){
		return "redirect:/errors/500";
	}

}
