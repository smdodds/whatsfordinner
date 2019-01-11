package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.data.RecipeDAO;
import com.revature.data.RecipeHibernate;

@RestController
public class RecipeController {
	@Autowired
	private RecipeDAO rd;
	
	@RequestMapping(value="/recipe",method=RequestMethod.GET)
	public List<Recipe> getAllRecipes() {		
		return rd.getRecipes();		
	}
	
	@RequestMapping(value="/recipe",method=RequestMethod.POST)
	public List<Recipe> createRecipe(@RequestBody Recipe newRecipe) {
		
		rd.insertRecipe(newRecipe);
		
		return rd.getRecipes();
	}
}
