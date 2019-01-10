package com.revature.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.User;

public class UserHibernateTest {
	UserDAO ud = new UserHibernate();
	@Test
	public void testAddUser() {
		User inserted = new User("gg","gg","Gavin","Greif","g@g.com");
		Integer i = ud.addUser(inserted);
		assertNotNull(i);
	}

	@Test
	public void testGetUserbyId() {
		User received = ud.getUserbyId(1);
		assertNotNull(received);
	}

	@Test
	public void testGetUserByEmailAndPassword() {
		User expected = new User();
		expected.setEmail("new@email.com");
		expected.setPassword("gg");
		User u = ud.getUserByEmailAndPassword(expected);
		assertNotNull(u);
	}

	@Test
	public void testGetUsers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdateUser() {
		User previous = new User("gg","gg","Gavin","Greif","g@g.com");
		User u = ud.getUserByEmailAndPassword(previous);
		previous.setId(u.getId());
		previous.setEmail("new@email.com");
		u = ud.updateUser(previous);
		assertEquals(previous.getEmail(), u.getEmail());
	}

	@Test
	public void testDeleteUser() {
		User toBeDeleted = new User("gg","gg","Gavin","Greif","new@email.com");
		User expected = ud.getUserByEmailAndPassword(toBeDeleted);
		toBeDeleted.setId(expected.getId());
		ud.deleteUser(toBeDeleted);
		expected = ud.getUserByEmailAndPassword(toBeDeleted);
		assertNull(expected);
	}
}
