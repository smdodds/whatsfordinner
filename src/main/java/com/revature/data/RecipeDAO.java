package com.revature.data;

import java.util.Set;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	public Recipe save(Recipe newRecipe);
	public Set<Recipe> getAll();
	public Recipe getById(int id);
	public Recipe getByName(String name);
	public Recipe update(Recipe r);
	public void delete(Recipe r);
}