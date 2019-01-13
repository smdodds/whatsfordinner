package com.revature.data;

import java.util.Set;

import com.revature.beans.User;

public interface UserDAO {
	Integer addUser(User u);
	User getUserbyId(int id);
	User getUserByEmailAndPassword(User u);
	Set<User>getUsers();
	User updateUser(User u);
	void deleteUser(User u);
}
