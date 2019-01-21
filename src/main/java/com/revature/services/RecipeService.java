package com.revature.services;

import java.util.List;
import java.util.Set;


import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;

public interface RecipeService {
	Recipe save(Recipe r);
	Set<Recipe> getAll();
	Recipe getById(int id);
	List<Recipe> getByName(String name);
	public List<Recipe> getByIngredient(List<Ingredient> ingredients);
	Recipe update(Recipe r);
	void delete(Recipe r);
}
