package com.revature.data;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Fridge;
import com.revature.utils.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FridgeHibernate.class, HibernateUtil.class})
@Transactional
public class FridgeHibernateTest {
	@Autowired(required=true)
	private FridgeDAO fd;
	
	@Test
	public void testSave() {
		// set up a fridge
		Fridge f = new Fridge();
		f.setUserId(1);
		assertNotNull(fd.save(f));	// save a new object
		assertNull(fd.save(f));		// attempt to save an existing object
		
		fd.delete(f);
	}

	@Test
	public void testGet() {
		// set up a fridge
		Fridge f = new Fridge();
		f.setUserId(1);
		assertNotNull(fd.save(f));
		
		// test entries that do and don't exist, by ID
		assertNotNull(fd.getById(f.getId()));
		assertNull(fd.getById(0));
		// test entries that do and don't exist, by User ID
		assertNotNull(fd.getByUserId(1));
		assertNull(fd.getByUserId(0));
		
		fd.delete(f);
	}

	@Test
	public void testUpdate() {
		// set up a fridge
		Fridge f = new Fridge();
		f.setUserId(1);
		assertNotNull(fd.save(f));
		
		// update the ingredient, see if it changed
		f.setUserId(2);
		assertNotNull(fd.update(f));
		assertNotNull(fd.getByUserId(f.getUserId()));
		assertNotNull(fd.update(f));
		
		fd.delete(f);
	}

	@Test
	public void testDelete() {
		// set up a fridge
		Fridge f = new Fridge();
		f.setUserId(1);
		assertNotNull(fd.save(f));
		
		// delete the object, test if it's gone
		fd.delete(f);
		assertNull(fd.getById(f.getId()));
	}

}
