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
import com.ty.foodappspring.dao.UserDao;
import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService us;

	@PostMapping("/user")
	public ResponseStructure<User> saveUser(@RequestBody User u) {
		return us.saveUser(u);
	}

	@GetMapping("/user")
	public ResponseStructure<User> getUser(@RequestParam int id) {
		return us.getUserById(id);
	}

	@PutMapping("/user")
	public ResponseStructure<User> updateuser(@RequestParam int id, @RequestBody User u) {
		return us.updatePerson(id, u);
	}

	@GetMapping("/allusers")
	public ResponseStructure<List<User>> getAllusers() {
		return us.getAllUsers();
	}

	@DeleteMapping("/user")
	public ResponseStructure<String> deleteUser(@RequestParam int id) {
		return us.deleteUserById(id);
	}
}
