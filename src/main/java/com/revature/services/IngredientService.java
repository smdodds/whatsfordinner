package com.revature.services;

import java.util.List;

import com.revature.beans.Ingredient;

public interface IngredientService {
	Ingredient save(Ingredient i);
	List<Ingredient> getAll();
	Ingredient getById(int id);
	Ingredient getByName(String name);
	Ingredient update(Ingredient i);
	void delete(Ingredient i);
}