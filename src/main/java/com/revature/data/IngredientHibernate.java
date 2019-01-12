package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Ingredient;
import com.revature.utils.HibernateUtil;

@Component
public class IngredientHibernate implements IngredientDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Ingredient save(Ingredient i) {
		Session s = hu.getSession();
		if(getByName(i.getName()) != null) {
			// cannot save an existing ingredient
			s.close();
			return null;
		}
		Transaction tx = s.beginTransaction();
		@SuppressWarnings("unused")
		int id = (Integer) s.save(i);
		tx.commit();
		s.close();
		return i;
	}

	@Override
	public List<Ingredient> getAll() {
		Session s = hu.getSession();
		Query<Ingredient> q = s.createQuery("FROM com.revature.beans.Ingredient", Ingredient.class);
		List<Ingredient> l = q.getResultList();
		s.close();
		return l;
	}

	@Override
	public Ingredient getById(int id) {
		Session s = hu.getSession();
		Ingredient i = s.get(Ingredient.class, id);
		s.close();
		return i;
	}

	@Override
	public Ingredient getByName(String name) {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Ingredient where NAME=:name";
		Query<Ingredient> q = s.createQuery(query, Ingredient.class);
		q.setParameter("name", name);
		List<Ingredient> l = q.list();
		s.close();
		if(l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	@Override
	public Ingredient update(Ingredient i) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		try {
			s.update(i);
			tx.commit();
		} catch (Exception e) {
			// exception logging should happen in LoggingAspect
			tx.rollback();
			s.close();
			return null;
		}
		s.close();
		return i;
	}

	@Override
	public void delete(Ingredient i) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(i);
		tx.commit();
		s.close();
	}

}
