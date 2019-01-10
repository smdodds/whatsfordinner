package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserSevice;

@RestController
@RequestMapping(value="/users")
public class UserController {
	@Autowired
	private UserSevice us;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestBody User u) {
		return us.login(u);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.GET)
	public User getUser(int id) {

		return us.getUserbyId(id);
		
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public Set<User> getUsers(){
		return us.getUsers();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public User addUser(User u) {
		return us.addUser(u);
	}
	
	@RequestMapping(value = "/users/", method= RequestMethod.PUT)
	public User updateUser(User u) {
		return us.updateUser(u);
	}
	
	@RequestMapping(value= "/users/", method= RequestMethod.DELETE)
	public void DeleteUser(User u) {
		us.deleteUser(u);
	}
}
