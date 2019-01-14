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
	public Recipe saveRecipe(Recipe newRecipe) {

		Session s = hu.getSession();
		if(getRecipeById(newRecipe.getId()) != null) {
			s.close();
			return null;
		}
		Transaction tx = s.beginTransaction();
		
		s.save(newRecipe);
		
		tx.commit();
		s.close();
		return newRecipe;
	}

	@Override
	public Set<Recipe> getRecipes() {
		
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe",Recipe.class);
		List<Recipe> rList = q.getResultList();
		 
		s.close();
		
		return new HashSet<Recipe>(rList);
	}

	@Override
	public Recipe getRecipeById(int id) {
		Session s = hu.getSession();
		Recipe r = s.get(Recipe.class, id);
		s.close();
		return r;
	}

	@Override
	public Recipe getRecipeByName(String name) {
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
	public Recipe updateRecipe(Recipe updateRecipe) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		
		try{
			s.update(updateRecipe);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			s.close();
			return null;
		}
		return updateRecipe;
	}

	@Override
	public void deleteRecipe(Recipe deleterecipe) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		s.delete(deleterecipe);
		tx.commit();
		s.close();
	}
}
