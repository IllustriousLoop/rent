package com.rentp.Database;

import java.util.ArrayList;

/**
 * Database
 *
 * @author <a href="mailto:jhair@jhairparis.com">Jhair Paris</a>
 */
public interface IDatabase<T> {
	ArrayList<T> getDatabase();

	int init();

	void save();

	String toString();
}
