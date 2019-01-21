package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;
import com.revature.data.RecipeDAO;

@Service
public class RecipeSpring implements RecipeService{
	@Autowired
	private RecipeDAO rd;
	
	@Override
	public Recipe save(Recipe r) {
		return rd.saveRecipe(r);
	}

	@Override
	public Set<Recipe> getAll() {
		return rd.getRecipes();
	}

	@Override
	public Recipe getById(int id) {
		return rd.getRecipeById(id);
	}

	@Override
	public List<Recipe> getByName(String name) {
		return rd.getRecipeByName(name);
	}
	
	public List<Recipe> getByIngredient(List<Ingredient> ingredients) {
		return rd.getRecipeByIngredients(ingredients);
	}

	@Override
	public Recipe update(Recipe r) {
		return rd.updateRecipe(r);
	}

	@Override
	public void delete(Recipe r) {
		rd.deleteRecipe(r);
	}

}
