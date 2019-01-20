package com.revature.services;

import java.util.List;

import com.revature.beans.Comment;

public interface CommentService {	
	Comment save(Comment c);
	List<Comment> getByRecipeId(int i);
	void delete(Comment c);
}
