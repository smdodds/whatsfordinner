package com.revature.controllers;


import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.data.RecipeDAO;

@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
	@Autowired
	private RecipeDAO rd;
	
	@RequestMapping(method=RequestMethod.GET)
	public Set<Recipe> getAllRecipes(HttpSession s) {
		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.getRecipes();	
		}	
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Recipe getRecipeById(@PathVariable("id") int id, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.getRecipeById(id);		
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Recipe createRecipe(@RequestBody Recipe newRecipe, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return rd.saveRecipe(newRecipe);
		}
	}
	@RequestMapping(method=RequestMethod.PUT)
	public Recipe updateRecipe(@RequestBody Recipe putRecipe, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
			return rd.updateRecipe(putRecipe);
		}
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteRecipe(@RequestBody Recipe deleteRecipe, HttpSession s){

		User u = (User) s.getAttribute("user");
		if (u != null) {
		rd.deleteRecipe(deleteRecipe);
		}
	}
}
