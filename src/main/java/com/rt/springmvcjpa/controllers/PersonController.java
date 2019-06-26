package com.rt.springmvcjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rt.springmvcjpa.model.Person;
import com.rt.springmvcjpa.service.PersonService;

/**
 * Person Controller
 * 
 * @author ykarav
 *
 */
@Controller
@RequestMapping("/")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(value = {"/listAllPersons", "/"}, method=RequestMethod.GET)
	public String listAllPersons(ModelMap model){
		model.addAttribute("listPersons", personService.findAll());
		return "person/listAllPersons";
	}
	
	@RequestMapping(value = {"/addPerson"}, method=RequestMethod.GET)
	public String addPerson(ModelMap model){
		Person person = new Person();
		model.addAttribute("person", person);
		return "person/addPerson";
	}
	
	@RequestMapping(value = {"/addPerson"}, method=RequestMethod.POST)
	public String savePerson(Person person, BindingResult result){
		if ( !result.hasErrors() ){
			personService.save(person);
		}
		return "redirect:/listAllPersons";
	}
	
	@RequestMapping(value = {"/editPerson/{personId}"}, method=RequestMethod.GET)
	public String editPerson(@PathVariable Long personId, ModelMap model){
		Person person = personService.findById(personId);
		model.addAttribute("person", person);
		return "person/editPerson";
	}
	
	@RequestMapping(value = {"/editPerson/{personId}"}, method=RequestMethod.POST)
	public String updatePerson(Person person, BindingResult result){
		if ( !result.hasErrors() ){
			personService.update(person);
		}
		return "redirect:/listAllPersons";
	}
	
	@RequestMapping(value = {"/deletePerson/{personId}"}, method=RequestMethod.GET)
	public String deletePerson(@PathVariable Long personId){
		personService.deleteById(personId);
		return "redirect:/listAllPersons";
	}

}
