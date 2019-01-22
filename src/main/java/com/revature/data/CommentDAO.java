package com.revature.data;

import java.util.List;

import com.revature.beans.Comment;

public interface CommentDAO {
	public Comment save(Comment c);
	public List<Comment> getByRecipeId(int i);
	public void delete(Comment c);
}
