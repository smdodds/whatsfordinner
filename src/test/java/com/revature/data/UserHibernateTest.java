package com.revature.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.User;

public class UserHibernateTest {
	UserDAO ud = new UserHibernate();
	@Test
	public void testAddUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUserbyId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUserByEmailAndPassword() {
		User expected = new User();
		expected.setEmail("e@e.com");
		expected.setPassword("p");
		expected.setId(1);
		User u = ud.getUserByEmailAndPassword(expected);
		assertEquals(u.getId(), expected.getId());
	}

	@Test
	public void testGetUsers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

}
