package com.revature.data;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Recipe;
import com.revature.utils.HibernateUtil;
import com.revature.beans.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RecipeHibernate.class, IngredientHibernate.class, HibernateUtil.class})
@Transactional
public class RecipeHibernateTest {
	
	private Recipe testRecipe = new Recipe();

	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	private Ingredient testingredient1 = new Ingredient();
	private Ingredient testingredient2 = new Ingredient();
	private Ingredient testingredient3= new Ingredient();

	@Autowired
	private IngredientDAO test1;

	@Autowired
	private RecipeDAO test2;
	
	@Test
	public void testAddRecipe(){
		testingredient1 = (Ingredient) test1.getById(-8);
		testingredient2 = (Ingredient) test1.getById(-7);
		testingredient3 = (Ingredient) test1.getById(-6);
		
		/*
		testingredient1.setName("Peanut Butter");
		testingredient2.setName("Jelly");
		testingredient3.setName("Bread");
		*/
		
		ingredients.add(testingredient1);
		ingredients.add(testingredient2);
		ingredients.add(testingredient3);
		
		testRecipe.setName("PB and J");
		testRecipe.setDescription("A nice, tasty sandwich");
		testRecipe.setIngredients(ingredients);
		
		test2.save(testRecipe);
		//test2.deleteRecipe(testRecipe);
	}
}
