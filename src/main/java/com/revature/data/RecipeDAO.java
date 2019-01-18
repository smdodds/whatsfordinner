package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	public Recipe save(Recipe newRecipe);
	public Set<Recipe> getAll();
	public Recipe getById(int id);
	public List<Recipe> getRecipeByName(String name);
	public Recipe update(Recipe updateRecipe);
	public void delete(Recipe deleterecipe);
}