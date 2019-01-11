package com.revature.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.Ingredient;

public class IngredientHibernateTest {
	private static IngredientDAO id = new IngredientHibernate();

	@Test
	public void testSave() {
		Ingredient i = new Ingredient();
		i.setName("TestSaveIngredient");
		assertNotNull(id.save(i));
	}
	
	@Test
	public void testSaveExistingIngredient() {
		Ingredient i = new Ingredient();
		i.setName("Butter");
		assertNull(id.save(i));
	}
	
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
