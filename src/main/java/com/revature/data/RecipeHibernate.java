package com.revature.data;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.beans.Recipe;

@Component
@Scope(scopeName="prototype")
public class RecipeHibernate implements RecipeDAO{

	@Override
	public List<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe getRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRecipe(Recipe newRecipe) {
		// TODO Auto-generated method stub
		
	}

}
