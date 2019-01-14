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
	private IngredientDAO test1 = new IngredientHibernate();

	@Autowired
	private RecipeDAO test2 = new RecipeHibernate();
	
	{
		/*
		testingredient1.setId(1);
		testingredient2.setId(2);
		testingredient3.setId(3);
		testingredient1.setName("Peanut Butter");
		testingredient2.setName("Jelly");
		testingredient3.setName("Bread");
		*/
		testingredient1 = test1.getById(-7);
		testingredient2 = test1.getById(-9);
		testingredient3 = test1.getById(-8);
		
		ingredients.add(testingredient1);
		ingredients.add(testingredient2);
		ingredients.add(testingredient3);
		
		testRecipe.setName("PB and J");
		testRecipe.setDescription("A nice, tasty sandwich");
		testRecipe.setIngredients(ingredients);
	}
	
	@Test
	public void testAddRecipe(){
		test2.saveRecipe(testRecipe);
		test2.deleteRecipe(testRecipe);
	}
}
