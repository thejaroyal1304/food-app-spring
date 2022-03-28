package com.ty.foodappspring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappspring.dto.Person;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.repository.PersonRepository;
import com.ty.foodappspring.repository.ProductRepository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepository pr;

	public Person savePerson(Person p) {
		return pr.save(p);
	}

	public Person getPerson(int id) {
		Optional<Person> opt = pr.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public Person updatePerson(int id, Person p) {
		Person person = getPerson(id);
		if (person != null) {
			pr.save(p);
			return p;
		}
		return null;
	}

	public List<Person> getAllPersons() {
		return pr.findAll();
	}

	public boolean deletePerson(int id) {
		Person p = pr.getById(id);
		if (p != null) {
			pr.deleteById(id);
			return true;

		}
		return false;
	}

}
