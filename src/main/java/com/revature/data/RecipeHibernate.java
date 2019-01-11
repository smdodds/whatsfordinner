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
	public Set<Recipe> getRecipes() {
		
		Session s = hu.getSession();
		
		String query = "from com.revature.beans.Recipe";
		Query<Recipe> q = s.createQuery(query,Recipe.class);
		List<Recipe> rList = q.getResultList();
		 
		s.close();
		
		return new HashSet<Recipe>(rList);
	}

	@Override
	public Recipe getRecipeById(int id) {
		
		return null;
	}

	@Override
	public void addRecipe(Recipe newRecipe) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(newRecipe);
		
		tx.commit();
		s.close();
	}

	@Override
	public void updateRecipe(Recipe updateRecipe) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		s.update(updateRecipe);
		tx.commit();
		s.close();
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
