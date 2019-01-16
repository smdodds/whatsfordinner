package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Fridge;
import com.revature.data.FridgeDAO;

@Service
public class FridgeSpring implements FridgeService {
	@Autowired
	private FridgeDAO fd;

	@Override
	public Fridge save(Fridge f) {
		return fd.save(f);
	}

	@Override
	public Fridge getById(int id) {
		return fd.getById(id);
	}

	@Override
	public Fridge getByUserId(int userId) {
		return fd.getByUserId(userId);
	}

	@Override
	public Fridge update(Fridge f) {
		return fd.update(f);
	}

	@Override
	public void delete(Fridge f) {
		fd.delete(f);
	}

}
