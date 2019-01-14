package com.revature.data;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.revature.beans.Recipe;
import com.revature.beans.Ingredient;

public class RecipeHibernateTest {
	
	private Recipe testRecipe = new Recipe();
	private Recipe ingredient = new Recipe();

	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	private Ingredient testingredient1 = new Ingredient();
	private Ingredient testingredient2 = new Ingredient();
	private Ingredient testingredient3= new Ingredient();

	private IngredientDAO test1 = new IngredientHibernate();
	private RecipeDAO test2 = new RecipeHibernate();
	
	{
		System.out.println("Creating test example");		
		
		testingredient1.setName("Peanut Butter");
		testingredient2.setName("Jelly");
		testingredient3.setName("Bread");
		
		ingredients.add(testingredient1);
		ingredients.add(testingredient2);
		ingredients.add(testingredient3);
		
		testRecipe.setName("PB and J");
		testRecipe.setDescription("A nice, tasty sandwich");
		testRecipe.setIngredients(ingredients);
	}
	
	@Test
	public void testAddRecipe(){
		test1.save(testingredient1);
		test1.save(testingredient2);
		test1.save(testingredient3);
	}
}
