package com.ty.foodappspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dao.UserDao;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.exception.NoIdFoundException;
@Service
public class UserService {
	@Autowired
	private UserDao ud;
	
	public ResponseStructure<User> saveUser(User u) {
		User user = ud.saveUser(u);
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("Success");
		rs.setData(u);
		return rs;
	}

	public ResponseStructure<User> getUserById(int id) {
		User user = ud.getUser(id);	
		ResponseStructure<User> rs = new ResponseStructure<User>();
		if (user != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(user);
			return rs;
		} else {
			String str = "No Id Found For User";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<List<User>> getAllUsers() {
		List<User> users = ud.getAllUsers();
		ResponseStructure<List<User>> rs = new ResponseStructure<List<User>>();
		if (users != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(users);
			return rs;
		} else {
			String str = "No User Added Yet,empty list";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<User> updatePerson(int id, User u) {
		User user = ud.updateUser(id, u);
		ResponseStructure<User> rs = new ResponseStructure<User>();
		if (user != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Updated");
			rs.setData(u);
			return rs;
		} else {
			String str = "No Id Found to update User";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<String> deleteUserById(int id) {
		boolean res = ud.deleteUser(id);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		if (res == true) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Deleted");
			rs.setData("Return value is TRUE");
			return rs;
		} else {
			String str = "No Id Found to Delete User";
			throw new NoIdFoundException(str);
		}
	}
}
