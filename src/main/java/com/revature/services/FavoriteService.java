package com.revature.services;

import com.revature.beans.Recipe;
import com.revature.beans.User;

public interface FavoriteService {
	User update(Recipe r, User u);
}
