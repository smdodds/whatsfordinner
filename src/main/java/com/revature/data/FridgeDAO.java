package com.revature.data;

import com.revature.beans.Fridge;

public interface FridgeDAO {
	Fridge save(Fridge f);
	Fridge getById(int id);
	Fridge getByUserId(int userId);
	Fridge update(Fridge f);
	void delete(Fridge f);
}
