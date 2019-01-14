package com.revature.data;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Ingredient;
import com.revature.utils.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IngredientHibernate.class, HibernateUtil.class})
@Transactional
public class IngredientHibernateTest {
	@Autowired(required=true)
	private IngredientDAO id;

	@Test
	public void testSave() {
		// set up an ingredient
		Ingredient i = new Ingredient();
		i.setName("TestIngredient");
		assertNotNull(id.save(i));	// save a new object
		assertNull(id.save(i));		// attempt to save an existing object
		
		id.delete(i);
	}
	
	@Test
	public void testGet() {
		Ingredient i = new Ingredient();
		i.setName("TestIngredient");
		assertNotNull(id.save(i));
		
		assertNotEquals(0, id.getAll().size());
		// test entries that do and don't exist, by ID
		assertNotNull(id.getById(i.getId()));
		assertNull(id.getById(0));
		// test entries that do and don't exist, by name
		assertNotNull(id.getByName("TestIngredient"));
		assertNull(id.getByName("Nothing"));
		
		id.delete(i);
	}

	@Test
	public void testUpdate() {
		// set up an ingredient
		Ingredient i = new Ingredient();
		i.setName("TestIngredient1");
		assertNotNull(id.save(i));
		
		// update the ingredient, see if it changed
		i.setName("TestIngredientUpdate");
		assertNotNull(id.update(i));
		assertNotNull(id.getByName("TestIngredientUpdate"));
		assertNotNull(id.update(i));
		
		// set up another ingredient
		Ingredient j = new Ingredient();
		j.setName("TestIngredient2");
		assertNotNull(id.save(j));
		j.setName("TestIngredientUpdate");
		assertNull(id.update(j));
		
		id.delete(i);
		id.delete(j);
	}

	@Test
	public void testDelete() {
		// set up an ingredient
		Ingredient i = new Ingredient();
		i.setName("TestIngredient");
		assertNotNull(id.save(i));
		
		// delete the object, test if it's gone
		id.delete(i);
		assertNull(id.getById(i.getId()));
	}

}
