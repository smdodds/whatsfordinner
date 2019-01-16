package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Ingredient;
import com.revature.beans.User;
import com.revature.services.IngredientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/ingredients")
public class IngredientController {
	@Autowired
	private IngredientService is;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> getAll(HttpSession s) {
		return is.getAll();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Ingredient getById(@PathVariable("id") int id, HttpSession s) {
		return is.getById(id);
	}

/*	@RequestMapping(value="{name}", method=RequestMethod.GET)
	public Ingredient getById(@QueryParam("name") String name, HttpSession s) {
		return is.getByName(name);
	}*/
	
	@RequestMapping(method = RequestMethod.POST)
	public Ingredient save(@RequestBody Ingredient i, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return is.save(i);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Ingredient update(@RequestBody Ingredient i, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return is.update(i);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody Ingredient i, HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u != null) {
			is.delete(i);
		}
	}
}
