package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	public Recipe save(Recipe newRecipe);
	public List<Recipe> getAll();
	public Recipe getById(int id);
	public List<Recipe> getByName(String name);
	public Recipe update(Recipe updateRecipe);
	public void delete(Recipe deleterecipe);
}