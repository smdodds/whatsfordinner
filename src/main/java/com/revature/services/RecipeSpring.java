package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Recipe;
import com.revature.data.RecipeDAO;

@Service
public class RecipeSpring implements RecipeService{
	@Autowired
	private RecipeDAO rd;
	
	@Override
	public Recipe save(Recipe r) {
		return rd.save(r);
	}

	@Override
	public List<Recipe> getAll() {
		return rd.getAll();
	}

	@Override
	public Recipe getById(int id) {
		return rd.getById(id);
	}

	@Override
	public List<Recipe> getByName(String name) {
<<<<<<< HEAD
		return rd.getRecipeByName(name);
=======
		return rd.getByName(name);
>>>>>>> 6c4b621a47acfe74cbb6eec275ddf4e70b514bc6
	}

	@Override
	public Recipe update(Recipe r) {
		return rd.update(r);
	}

	@Override
	public void delete(Recipe r) {
		rd.delete(r);
	}

}
