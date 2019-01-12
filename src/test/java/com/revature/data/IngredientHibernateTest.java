package com.revature.data;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Ingredient;
import com.revature.utils.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IngredientHibernate.class, HibernateUtil.class})
@Transactional
public class IngredientHibernateTest {
	@Autowired(required=true)
	private IngredientDAO id;
	
	//private static ApplicationContext ac;
	//private static IngredientDAO id = new IngredientHibernate();

	@Test
	public void testSave() {
		Ingredient i = new Ingredient();
		i.setName("TestIngredient");
		assertNotNull(id.save(i));	// save a new object
		assertNull(id.save(i));		// attempt to save an existing object
	}
	
	@Test
	public void testGet() {
		assertNotEquals(0, id.getAll().size());
		// test entries that do and don't exist, by ID
		assertNotNull(id.getById(1));
		assertNull(id.getById(0));
		// test entries that do and don't exist, by name
		assertNotNull(id.getByName("TestIngredient"));
		assertNull(id.getByName("Nothing"));
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
