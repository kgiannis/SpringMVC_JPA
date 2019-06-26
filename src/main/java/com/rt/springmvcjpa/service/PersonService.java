package com.rt.springmvcjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rt.springmvcjpa.dao.PersonDAO;
import com.rt.springmvcjpa.model.Person;

/**
 * Service of Person Entity
 * 
 * @author ykarav
 *
 */
@Service
@Transactional
public class PersonService {

	
	@Autowired
	private PersonDAO personDao;
		
	
	public Person findById(Long id){
		return personDao.findById(id);
	}
	
	public List<Person> findAll(){
		return personDao.findAll();
	}
	
	public void save(Person entity){
		personDao.save(entity);
	}
	
	public void update(Person entity){
		personDao.update(entity);
	}
	
	public void deleteById(Long id){
		personDao.deleteById(id);
	}
	
	public void delete(Person entity){
		personDao.delete(entity);
	}
}
