package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Comment;
import com.revature.data.CommentDAO;

@Service
public class CommentSpring implements CommentService{
	@Autowired CommentDAO cd;

	@Override
	public Comment save(Comment c) {
		return cd.save(c);
	}

	@Override
	public List<Comment> getByRecipeId(int i) {
		return cd.getByRecipeId(i);
	}

	@Override
	public void delete(Comment c) {
		cd.delete(c);
	}	
}
