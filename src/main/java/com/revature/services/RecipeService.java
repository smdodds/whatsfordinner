package com.revature.services;

import java.util.Set;

import com.revature.beans.Recipe;

public interface RecipeService {
	Recipe save(Recipe r);
	Set<Recipe> getAll();
	Recipe getById(int id);
	Recipe getByName(String name);
	Recipe update(Recipe r);
	void delete(Recipe r);
}
