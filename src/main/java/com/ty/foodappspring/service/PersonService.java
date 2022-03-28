package com.ty.foodappspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodappspring.dao.PersonDao;
import com.ty.foodappspring.dao.ProductDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.Person;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.exception.NoIdFoundException;
@Service
public class PersonService {
	@Autowired
	private PersonDao pd;

	public ResponseStructure<Person> savePerson(Person p) {
		Person person = pd.savePerson(p);
		ResponseStructure<Person> rs = new ResponseStructure<Person>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("Success");
		rs.setData(p);
		return rs;
	}

	public ResponseStructure<Person> getPersonById(int id) {
		Person person = pd.getPerson(id);
		ResponseStructure<Person> rs = new ResponseStructure<Person>();
		if (person != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(person);
			return rs;
		} else {
			String str = "No Id Found For Person";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<List<Person>> getAllPersons() {
		List<Person> persons = pd.getAllPersons();
		ResponseStructure<List<Person>> rs = new ResponseStructure<List<Person>>();
		if (persons != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(persons);
			return rs;
		} else {
			String str = "No Person Added Yet,empty list";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<Person> updateProduct(int id, Person p) {
		Person person = pd.updatePerson(id, p);
		ResponseStructure<Person> rs = new ResponseStructure<Person>();
		if (person != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Updated");
			rs.setData(p);
			return rs;
		} else {
			String str = "No Id Found to update Person";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<String> deletePersonById(int id) {
		boolean res = pd.deletePerson(id);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		if (res == true) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Deleted");
			rs.setData("Return value is TRUE");
			return rs;
		} else {
			String str = "No Id Found to Delete Person";
			throw new NoIdFoundException(str);
		}
	}

}
