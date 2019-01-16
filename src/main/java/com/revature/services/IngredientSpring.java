package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Ingredient;
import com.revature.data.IngredientDAO;

@Service
public class IngredientSpring implements IngredientService {
	@Autowired
	private IngredientDAO id;
	
	@Override
	public Ingredient save(Ingredient i) {
		return id.save(i);
	}

	@Override
	public List<Ingredient> getAll() {
		return id.getAll();
	}

	@Override
	public Ingredient getById(int id) {
		return this.id.getById(id);
	}

	@Override
	public Ingredient getByName(String name) {
		return id.getByName(name);
	}

	@Override
	public Ingredient update(Ingredient i) {
		return id.update(i);
	}

	@Override
	public void delete(Ingredient i) {
		id.delete(i);
	}

}
