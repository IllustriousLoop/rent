package com.rentp.Database;

import java.util.ArrayList;

/**
 * Database extends {@link Database}
 *
 * @author <a href="mailto:jhair@jhairparis.com">Jhair Paris</a>
 */
public class DatabaseUsers extends Database {
    public DatabaseUsers() {
        super("DatabaseUsers.csv", 5);
    }

    /**
     * Method for add new User to database in memory
     * <bold>Remember</bold> save DATABASE
     *
     * @param name     the name of new User
     * @param lastName the last name of new User
     * @param email    the email of new User
     * @return ArrayList<String>
     */
    public ArrayList<String> addNewUser(String name, String lastName, String email, String password) {
        ArrayList<String> newUser = new ArrayList<>();

        if (this.database.size() > 0)
            newUser.add(0, lastId + 1 + "");
        else
            newUser.add(0, lastId + "");
        newUser.add(1, name);
        newUser.add(2, lastName);
        newUser.add(3, email);
        newUser.add(4, password);

        this.database.add(newUser);
        return newUser;
    }

    /**
     * @param id
     * @param name
     * @param lastName
     * @param email
     */
    public boolean modifyById(int id, String name, String lastName, String email) {
        if (!(id >= this.database.size() || id < 0)) {
            this.database.get(id).set(1, name);
            this.database.get(id).set(2, lastName);
            this.database.get(id).set(3, email);
            return true;
        }
        System.out.println("Invalid id: " + id);
        return false;
    }

    /**
     * @param id of User in the database
     */
    public boolean deleteById(int id) {
        if (!(id >= this.database.size() || id < 0)) {
            this.database.remove(id);
            if (this.database.size() > 0)
                for (int i = 0; i < this.database.size(); i++)
                    this.database.get(i).set(0, i + "");
            return true;
        }
        System.out.println("Invalid id: " + id);
        return false;
    }

    public boolean auth(String email, String password) {
        for (ArrayList<String> User : database) {
            if (User.get(3).equals(email) && User.get(4).equals(password)) {
                return true;
            }
        }
        System.out.println("Please try again with: " + database.get(0).get(3) + " - " + database.get(0).get(4));
        return false;
    }
}
