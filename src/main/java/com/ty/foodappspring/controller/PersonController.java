package com.ty.foodappspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.Person;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.service.PersonService;
@RestController
public class PersonController {
	@Autowired
	private PersonService ps;

	@PostMapping("/person")
	public ResponseStructure<Person> savePerson(@RequestBody Person p) {
		return ps.savePerson(p);
	}

	@GetMapping("/person")
	public ResponseStructure<Person> getPerson(@RequestParam int id) {
		return ps.getPersonById(id);
	}

	@GetMapping("/allpersons")
	public ResponseStructure<List<Person>> getAllPersons() {
		return ps.getAllPersons();
	}

	@PutMapping("/person")
	public ResponseStructure<Person> updatePerson(@RequestParam int id, @RequestBody Person p) {
		return ps.updateProduct(id, p);
	}

	@DeleteMapping("/person")
	public ResponseStructure<String> DeletePerson(@RequestParam int id) {
		return ps.deletePersonById(id);
	}

}
