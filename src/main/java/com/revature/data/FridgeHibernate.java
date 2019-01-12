package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Fridge;
import com.revature.utils.HibernateUtil;

@Component
public class FridgeHibernate implements FridgeDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public Fridge save(Fridge f) {
		Session s = hu.getSession();
		if(getById(f.getId()) != null) {
			// cannot save an existing fridge
			s.close();
			return null;
		}
		Transaction tx = s.beginTransaction();
		s.save(f);
		tx.commit();
		s.close();
		return f;
	}

	@Override
	public Fridge getById(int id) {
		Session s = hu.getSession();
		Fridge f = s.get(Fridge.class, id);
		s.close();
		return f;
	}

	@Override
	public Fridge getByUserId(int userId) {
		Session s = hu.getSession();
		String query = "FROM com.revature.beans.Fridge WHERE USERID=:userId";
		Query<Fridge> q = s.createQuery(query, Fridge.class);
		q.setParameter("userId", userId);
		List<Fridge> l = q.getResultList();
		s.close();
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	@Override
	public Fridge update(Fridge f) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		try {
			s.update(f);
			tx.commit();
		} catch (Exception e) {
			// exception logging should happen in LoggingAspect
			tx.rollback();
			s.close();
			return null;
		}
		s.close();
		return f;
	}

	@Override
	public void delete(Fridge f) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(f);
		tx.commit();
		s.close();
	}
}
