package com.revature.services;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeService {
	Recipe save(Recipe r);
	List<Recipe> getAll();
	Recipe getById(int id);
	List<Recipe> getByName(String name);
	Recipe update(Recipe r);
	void delete(Recipe r);
}
