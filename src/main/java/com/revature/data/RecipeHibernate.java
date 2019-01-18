package com.revature.data;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
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
		Transaction tx = s.beginTransaction();
		
		try {			
			s.save(r);
			tx.commit();			
			s.close();
		}
		catch(Exception e) {
			tx.rollback();
			s.close();
			return null;
		}
		return r;
	}

	@Override
	public List<Recipe> getAll() {
		
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe",Recipe.class);
		List<Recipe> rList = q.getResultList();
		 
		s.close();
		
		return rList;
	}

	@Override
	public Recipe getById(int id) {
		Session s = hu.getSession();
		Recipe r = s.get(Recipe.class, id);
		s.close();
		return r;
	}

	@Override
	public List<Recipe> getByName(String name) {
    
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe where upper(NAME) like '%' || :name || '%' ",Recipe.class);
		name = name.toUpperCase();
		q.setParameter("name", name);
		List<Recipe> rList = q.getResultList();
		 
		s.close();

		if(rList.isEmpty()) {
			return null;
		}
		else {
			return rList;
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
