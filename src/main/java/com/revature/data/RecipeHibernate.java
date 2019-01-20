package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;
import com.revature.utils.HibernateUtil;

@Component
@Scope
public class RecipeHibernate implements RecipeDAO{

	@Autowired
	private HibernateUtil hu;

	@Override
	public Recipe saveRecipe(Recipe r) {

		Session s = hu.getSession();
		if(getRecipeById(r.getId()) != null) {
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
	public List<Recipe> getRecipeByName(String name) {
    
		Session s = hu.getSession();
		
		Query<Recipe> q = s.createQuery("from com.revature.beans.Recipe where upper(NAME) like '%' || :name || '%' order by name",Recipe.class);
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

	public List<Recipe> getRecipeByIngredients(List<Ingredient> ingredients) {
	    
		Session s = hu.getSession();
		
		List<Integer> ids = new ArrayList<>();
		for(int i = 0; i<ingredients.size(); i++)
			ids.add(ingredients.get(i).getId());
		
		String sql = " select DISTINCT recipe.* from recipe join "
				+ "(select DISTINCT recipeid, ingredientid from ingredientlist where ingredientid in (:ids)) "
				+ "b on recipe.id = b.recipeid order by recipe.name";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(Recipe.class);
		query.setParameterList("ids", ids);
		List<Recipe> rList = query.list();
		
		return rList;
	}

	
	@Override
	public Recipe updateRecipe(Recipe r) {

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
	public void deleteRecipe(Recipe r) {

		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		s.delete(r);
		tx.commit();
		s.close();
	}
}
