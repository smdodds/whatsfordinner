package com.revature.services;

import com.revature.beans.Fridge;

public interface FridgeService {
	Fridge save(Fridge f);
	Fridge getById(int id);
	Fridge getByUserId(int userId);
	Fridge update(Fridge f);
	void delete(Fridge f);
}
