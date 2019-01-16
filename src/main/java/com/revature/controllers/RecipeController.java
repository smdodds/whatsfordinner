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

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.services.RecipeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value="/recipe")
public class RecipeController {
	@Autowired
	private RecipeService rd;
	
	@RequestMapping(method=RequestMethod.GET)
	public Set<Recipe> getAllRecipes(HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.getAll();	
		}	
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Recipe getRecipeById(@PathVariable("id") int id, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.getById(id);		
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Recipe createRecipe(@RequestBody Recipe newRecipe, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.save(newRecipe);
		}
	}
	@RequestMapping(method=RequestMethod.PUT)
	public Recipe updateRecipe(@RequestBody Recipe putRecipe, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return rd.update(putRecipe);
		}
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteRecipe(@RequestBody Recipe deleteRecipe, HttpSession s){

		User u = (User) s.getAttribute("user");
		if (u != null) {
		rd.delete(deleteRecipe);
		}
	}
}
