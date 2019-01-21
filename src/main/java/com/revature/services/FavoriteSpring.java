package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.data.RecipeDAO;
import com.revature.data.UserDAO;

@Service
public class FavoriteSpring implements FavoriteService {
	@Autowired
	private UserDAO ud;
	
	@Autowired
	private RecipeDAO rd;
	
	@Override
	public User update(Recipe r, User u) {
		// add recipe to user's favorites list, update through UserDAO
		u.addFavorite(r);
		return ud.updateUser(u);
	}

	@Override
	public void delete(User u, Integer id) {
		u.removeFavorite(rd.getById(id));
		ud.updateUser(u);
	}

}
