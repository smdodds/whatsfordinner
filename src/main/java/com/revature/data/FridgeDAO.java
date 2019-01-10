package com.revature.data;

import com.revature.beans.Fridge;

public interface FridgeDAO {
	Fridge create(Fridge f);
	Fridge getById(int id);
	Fridge getByUserId(int id);
	Fridge update(Fridge f);
	void delete(Fridge f);
}
