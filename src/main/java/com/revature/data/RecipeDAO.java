package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	public List<Recipe> getRecipes();
	public Recipe getRecipe();
	public void insertRecipe(Recipe newRecipe);
}
