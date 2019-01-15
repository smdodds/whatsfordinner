package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Fridge;
import com.revature.beans.User;
import com.revature.services.FridgeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/fridge")
public class FridgeController {
	@Autowired
	private FridgeService fs;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Fridge getById(@PathVariable("id") int id, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return fs.getById(id);
		}
	}

/*	@RequestMapping(value="{userId}", method=RequestMethod.GET)
	public Fridge getByUserId(@PathVariable("userId") int userId, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return fs.getByUserId(userId);
		}
	}*/
	
	@RequestMapping(method = RequestMethod.POST)
	public Fridge save(@RequestBody Fridge f, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return fs.save(f);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Fridge update(@RequestBody Fridge f, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return fs.update(f);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody Fridge f, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u != null) {
			fs.delete(f);
		}
	}
}