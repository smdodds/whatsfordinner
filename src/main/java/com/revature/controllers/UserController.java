package com.revature.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserSevice;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserSevice us;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User u, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null) {
			u = us.login(u);
			session.setAttribute("user", u);
			session.setMaxInactiveInterval(0);
			return u;
		} else {
			return sessionUser;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.DELETE)
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int id, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null) {
			return null;
		} else {
			return us.getUserbyId(1);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public Set<User> getUsers(HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null) {
			return null;
		} else {
			return us.getUsers();
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User u) {
			int id = us.addUser(u);
			return us.getUserbyId(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User u, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null) {
			return null;
		} else {
			return us.updateUser(u);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void DeleteUser(@RequestBody User u, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser != null) {
			us.deleteUser(u);
		}
	}

}
