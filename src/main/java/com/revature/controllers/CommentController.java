
package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Comment;
import com.revature.beans.User;
import com.revature.services.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	private CommentService cs;
	
	@RequestMapping(method=RequestMethod.POST)
	public Comment saveComment(@RequestBody Comment newComment, HttpSession s) {

		User u = (User) s.getAttribute("user");
		if (u == null) {
			return null;
		} else {
		return cs.save(newComment);
		}
	}

	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public List<Comment> getrecipeComments(@PathVariable("id") int id){
		return cs.getByRecipeId(id);
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteComment(@RequestBody Comment deleteComment, HttpSession s){

		User u = (User) s.getAttribute("user");
		
		if (u != null) {
		cs.delete(deleteComment);
		}
	}
}