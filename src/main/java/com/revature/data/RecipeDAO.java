package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	public Set<Recipe> getRecipes();
	public Recipe getRecipeById(int id);
	public void addRecipe(Recipe newRecipe);
	public void updateRecipe(Recipe updateRecipe);
	public void deleteRecipe(Recipe deleterecipe);
}