package com.revature.services;

import java.util.Set;

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
	public Set<Recipe> getAll() {
		return rd.getAll();
	}

	@Override
	public Recipe getById(int id) {
		return rd.getById(id);
	}

	@Override
	public Recipe getByName(String name) {
		return rd.getByName(name);
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
