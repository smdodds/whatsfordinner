package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public User getUser(@PathVariable("id") int id) {
		return us.getUserbyId(1);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Set<User> getUsers(){
		Set<User> u = new HashSet<>();
		u = us.getUsers();
		return us.getUsers();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public User addUser(@RequestBody User u) {
		int id= us.addUser(u);
		return us.getUserbyId(id);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public User updateUser(@RequestBody User u) {
		return us.updateUser(u);
	}
	
	@RequestMapping(method= RequestMethod.DELETE)
	public void DeleteUser(@RequestBody User u) {
		us.deleteUser(u);
	}
}
