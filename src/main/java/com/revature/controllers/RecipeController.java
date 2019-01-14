package com.revature.controllers;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.data.RecipeDAO;

@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
	@Autowired
	private RecipeDAO rd;
	
	@RequestMapping(method=RequestMethod.GET)
	public Set<Recipe> getAllRecipes() {		
		return rd.getRecipes();		
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Recipe getRecipeById(@PathVariable("id") int id) {
		
		return rd.getRecipeById(id);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Set<Recipe> createRecipe(@RequestBody Recipe newRecipe) {
		
		rd.saveRecipe(newRecipe);
		
		return rd.getRecipes();
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteRecipe(@RequestBody Recipe deleteRecipe){
		
		rd.deleteRecipe(deleteRecipe);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public void updateRecipe(@RequestBody Recipe putRecipe) {
		
		rd.updateRecipe(putRecipe);
	}
}
