package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Fridge;
import com.revature.beans.User;
import com.revature.data.FridgeDAO;
import com.revature.data.UserDAO;

@Service
public class UserSpring implements UserSevice {
	@Autowired
	private UserDAO ud;
	@Autowired
	private FridgeDAO fd;
	@Override
	public Integer addUser(User u) {
		int i = ud.addUser(u);
		Fridge f = new Fridge();
		f.setUserId(i);
		fd.save(f);
		return i;
	}

	@Override
	public User getUserbyId(int id) {
		return ud.getUserbyId(id);
	}

	@Override
	public User login(User u) {
		return ud.getUserByEmailAndPassword(u);
	}

	@Override
	public Set<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public User updateUser(User u) {
		return ud.updateUser(u);
	}

	@Override
	public void deleteUser(User u) {
		ud.deleteUser(u);
		
	}
}
