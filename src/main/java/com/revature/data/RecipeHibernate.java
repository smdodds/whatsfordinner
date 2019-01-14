package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.beans.Recipe;
import com.revature.utils.HibernateUtil;

@Component
@Scope
public class RecipeHibernate implements RecipeDAO{

	@Autowired
	private HibernateUtil hu;

	@Override
	public Recipe save(Recipe r) {

		Session s = hu.getSession();
		if(getById(r.getId()) != null) {
			s.close();
			return null;
		}
		Transaction tx = s.beginTransaction();
		
		s.save(r);
		
		tx.commit();
		s.close();
		return r;
	}

	@Override
	public Set<Recipe> getAll() {
		
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe",Recipe.class);
		List<Recipe> rList = q.getResultList();
		 
		s.close();
		
		return new HashSet<Recipe>(rList);
	}

	@Override
	public Recipe getById(int id) {
		Session s = hu.getSession();
		Recipe r = s.get(Recipe.class, id);
		s.close();
		return r;
	}

	@Override
	public Recipe getByName(String name) {
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe where NAME=name:",Recipe.class);
		List<Recipe> rList = q.getResultList();
		 
		s.close();

		if(rList.isEmpty()) {
			return null;
		}
		else {
			return rList.get(0);
		}
	}

	@Override
	public Recipe update(Recipe r) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		
		try{
			s.update(r);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			s.close();
			return null;
		}
		return r;
	}

	@Override
	public void delete(Recipe r) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		s.delete(r);
		tx.commit();
		s.close();
	}
}
