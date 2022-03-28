package com.ty.foodappspring.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@Repository
public class UserDao {
	@Autowired
	UserRepository ur;

	public User saveUser(User u) {
		return ur.save(u);
	}

	public User getUser(int id) {
		Optional<User> opt = ur.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public User updateUser(int id, User u) {
		User user = getUser(id);
		if (user != null) {
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			user.setPwd(u.getPwd());
			user.setRole(u.getRole());
			return ur.save(u);
		}
		return null;

	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public boolean deleteUser(int id) {
		User u = getUser(id);
		if (u != null) {
			ur.deleteById(id);
			return true;
		}
		return false;
	}
}
