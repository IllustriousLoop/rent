package com.rentp.Database;

import java.util.ArrayList;

/**
 * DatabaseCars extends {@link Database}
 *
 * @author <a href="mailto:jhair@jhairparis.com">Jhair Paris</a>
 */
public class DatabaseCars extends Database {
	public DatabaseCars() {
		super("DatabaseCars.csv", 5);
	}

	public ArrayList<String> addNewCar(String name, String lastName, String email) {
		ArrayList<String> newCar = new ArrayList<String>();

		if (this.database.size() > 0)
			newCar.add(0, this.lastId + 1 + "");
		else
			newCar.add(0, this.lastId + "");

		newCar.add(1, name);
		newCar.add(2, lastName);
		newCar.add(3, email);

		this.database.add(newCar);

		return newCar;
	}
}
