package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Comment;
import com.revature.utils.HibernateUtil;

@Component
public class CommentHibernate implements CommentDAO{

	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Comment save(Comment c) {

		Session s= hu.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(c);
			tx.commit();
			s.close();
		}catch(Exception e) {
			tx.rollback();
			s.close();
			return null;
		}
		
		return c;
	}

	@Override
	public List<Comment> getByRecipeId(int i) {

		Session s= hu.getSession();

		Query<Comment> q = s.createQuery("from com.revature.beans.Comment where RecipeId=:i",Comment.class);

		List<Comment> cList = q.getResultList();
		
		s.close();
		if(cList.isEmpty()) {

			return null;
		}else {
			return cList;
		}
	}

	@Override
	public void delete(Comment c) {
		Session s = hu.getSession();
		
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();
	}
}
