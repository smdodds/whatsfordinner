package com.revature.services;

import java.util.Set;

import com.revature.beans.User;

public interface UserSevice {
	Integer addUser(User u);
	User getUserbyId(int id);
	User login(User u);
	Set<User>getUsers();
	User updateUser(User u);
	void deleteUser(User u);
	User getUserByEmail(User u);
	User getUserByUsername(User u);
}
