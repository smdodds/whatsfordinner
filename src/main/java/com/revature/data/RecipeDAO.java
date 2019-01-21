package com.revature.data;

import java.util.List;

import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;

public interface RecipeDAO {
	public Recipe saveRecipe(Recipe newRecipe);
	public Set<Recipe> getRecipes();
	public Recipe getRecipeById(int id);
	public List<Recipe> getRecipeByName(String name);
	public List<Recipe> getRecipeByIngredients(List<Ingredient> ingredients);
	public Recipe updateRecipe(Recipe updateRecipe);
	public void deleteRecipe(Recipe deleterecipe);
}