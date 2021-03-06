package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

@Component
public class UserHibernate implements UserDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public Integer addUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		Integer i = (Integer) s.save(u);
		tx.commit();
		s.close();
		return i;
	}

	@Override
	public User getUserbyId(int id) {
		Session s = hu.getSession();
		User u = s.get(User.class, id);
		s.close();
		return u;
	}

	@Override
	public User getUserByEmailAndPassword(User u) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.User where EMAIL=:email and PASSWORD=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("email", u.getEmail());
		q.setParameter("password", u.getPassword());
		List<User> l = q.list();
		if(l.isEmpty()) {
			s.close();
			return null;
		} else {
			s.close();
			return l.get(0);
		}
	}

	@Override
	public Set<User> getUsers() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.User";
		Query<User> q = s.createQuery(query,User.class);
		List<User> uList = q.getResultList();
		s.close();
		return new HashSet<User>(uList);
	}

	@Override
	public User updateUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(u);
		tx.commit();
		s.close();
		return u;
	}

	@Override
	public void deleteUser(User u) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(u);
		tx.commit();
		s.close();
		
	}
	
	@Override
	public User getUserByEmail(User u) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.User where EMAIL=:email";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("email", u.getEmail());
		List<User> l = q.list();
		if(l.isEmpty()) {
			s.close();
			return null;
		} else {
			s.close();
			return l.get(0);
		}
	}
	
	@Override
	public User getUserByUsername(User u) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.User where USERNAME=:username";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", u.getUsername());
		List<User> l = q.list();
		if(l.isEmpty()) {
			s.close();
			return null;
		} else {
			s.close();
			return l.get(0);
		}
	}

}
