package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.services.FavoriteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/favorite")
public class FavoriteController {
	@Autowired
	private FavoriteService fs;
	
	@RequestMapping(method = RequestMethod.POST)
	public User update(@RequestBody Recipe r, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			// sanity check that recipe isn't already on favorites list
			if(!u.getFavorites().contains(r)) {
				return fs.update(r, u);
			} else { 
				return u; 
			}
		}
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u != null) {
			fs.delete(u, id);
		}
	}
	
}
