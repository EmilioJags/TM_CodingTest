package com.tmexam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmexam.dao.PersonDao;
import com.tmexam.model.Person;

@RestController
@RequestMapping("/api/tm")
@CrossOrigin
public class PersonController {
	
	@Autowired
	PersonDao personDao;
	
	@GetMapping("/{id}")
	public Optional<Person> getPersonById(@PathVariable long id)
	{
		System.out.println("getPersonById called ...");
		return personDao.findById(id);	
	}
	
	@GetMapping
	public List<Person> getPersonList()
	{	
		// for simple logging, could be better implemented with AOP
		System.out.println("getPersonList called ...");
		return personDao.findAll();	
	}
	
	@PostMapping
	public boolean addPerson(@RequestBody Person newPerson)
	{
		Person saved = personDao.save(newPerson);
		System.out.println("Saving new data ... ");
		return saved != null;
	}
	//@GetMapping
	//public String getTest()
	//{
	//	return "Hello, it's working";
	//}
}
