package com.revature.services;

import java.util.Set;

import com.revature.beans.User;

public interface UserSevice {
	User addUser(User u);
	User getUserbyId(int id);
	User login(User u);
	Set<User>getUsers();
	User updateUser(User u);
	void deleteUser(User u);
}
