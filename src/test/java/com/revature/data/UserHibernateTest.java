package com.revature.data;

import static org.junit.Assert.*;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserHibernate.class, HibernateUtil.class})
@Transactional
public class UserHibernateTest {
	@Autowired(required=true)
	UserDAO ud;
	
	@Test
	public void testAddUser() {
		//Test Code
		
			//Adding a User
		User inserted = new User("gg","gg","G1","G2","g@g.com");
		Integer i = ud.addUser(inserted);
		
		//Deleting Database Changes
			//Ensuring we have the ID
		inserted = ud.getUserByEmailAndPassword(inserted);
		ud.deleteUser(inserted);
		
		//Test
		assertNotEquals((int) i, 0);
	}

	@Test
	public void testGetUserbyId() {
		//Test Code
			
			//Adding a User
		User inserted = new User(1,"gg","gg","G1","G2","g@g.com");
		ud.addUser(inserted);
		
			//Ensure we have the ID
		inserted = ud.getUserByEmailAndPassword(inserted);
		
			//Searching for that User
		User received = ud.getUserbyId(inserted.getId());
		
		//Deleting Database Changes
		ud.deleteUser(inserted);
		
		//Test
		assertNotNull(received);
	}

	@Test
	public void testGetUserByEmailAndPassword() {

		//Test Code
		
			//Adding a User
		User inserted = new User(1,"gg","gg","G1","G2","g@g.com");
		ud.addUser(inserted);
			//Searching for that User
		User found = ud.getUserByEmailAndPassword(inserted);
		
		//Deleting Database Changes
		ud.deleteUser(inserted);
		
		//Test
		assertNotNull(found);
	}

	@Test
	public void testGetUserswithFavorites() {
		System.out.println(ud.getUserbyId(1).getFavorites().toString());
		assertNotNull(ud.getUserbyId(1));
	}
	@Test
	public void testGetUsers() {
		
			//Adding Users
		User u1 = new User(1,"gg","gg","G1","G2","g@g.com");
		User u2 = new User(2,"hh","hh","H1","H2","h@h.com");
		User u3 = new User(3,"ii","ii","I1","I2","i@i.com");
		ud.addUser(u1);
		ud.addUser(u2);
		ud.addUser(u3);
		
			//Search for those Users
		Set<User> uList = ud.getUsers();

		//Delete Database Changes
		ud.deleteUser(u1);
		ud.deleteUser(u2);
		ud.deleteUser(u3);
		
		//Test
		assertTrue(uList.contains(u2));
	}

	@Test
	public void testUpdateUser() {
		//Test Code
		
			//Adding a User
		User previous = new User(1,"gg","gg","G1","G2","g@g.com");
		ud.addUser(previous);
		
			//Ensure we have the ID
		previous = ud.getUserByEmailAndPassword(previous);
		
			//Updating that User through the ID
		User u = new User(1,"hh","hh","H1","H2","h@h.com");
		u.setId(previous.getId());
		ud.updateUser(u);
		
			//Saving data from the updated User
		User updated = ud.getUserbyId(previous.getId());
		
		//Deleting Database Changes
		ud.deleteUser(u);
		
		//Test
		assertNotEquals(previous, updated);
	}

	@Test
	public void testDeleteUser() {
		//Test Code
		
			//Adding a User
		User toBeDeleted = new User("gg","gg","G1","G2","g@g.com");
		ud.addUser(toBeDeleted);
		
			//Ensure we have the ID
		toBeDeleted = ud.getUserByEmailAndPassword(toBeDeleted);
		
			//Deleting User
		ud.deleteUser(toBeDeleted);
		
			//Searching for that User
		User expected = ud.getUserByEmailAndPassword(toBeDeleted);
		
		//Test
		assertNull(expected);
	}

}
