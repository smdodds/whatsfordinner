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
	private static HibernateUtil hu;
	//private static HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Fridge create(Fridge f) {
		Session s = hu.getSession();
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
	public Fridge getByUserId(int id) {
		Session s = hu.getSession();
		String hql = "FROM com.revature.beans WHERE USERID:userId";
		Query<Fridge> q = s.createQuery(hql, Fridge.class);
		q.setParameter("userId", id);
		List<Fridge> l = q.getResultList();
		if(l.isEmpty()) {
			s.close();
			return null;
		} else {
			s.close();
			return l.get(0);
		}
	}

	@Override
	public Fridge update(Fridge f) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(f);
		tx.commit();
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
