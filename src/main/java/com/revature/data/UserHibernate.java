package com.revature.data;

import java.util.Set;

import org.hibernate.Hibernate;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserHibernate implements UserDAO {
	private static HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmailAndPassword(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

}
