package com.rentp.Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Database
 *
 * @author <a href="mailto:jhair@jhairparis.com">Jhair Paris</a>
 */
public class Database implements IDatabase<ArrayList<String>> {
    protected ArrayList<ArrayList<String>> database = new ArrayList<>();
    protected ArrayList<String> headers = new ArrayList<>();
    protected int lastId;
    static String home = "/home/jhair/Programing/Java/";
    private static final String path = home + "rent/src/main/java/com/rentp/Database/";
    private final int columns;
    private final File file;

    public Database(String name, int c) {
        this.file = new File(path + name);
        this.columns = c;
        this.lastId = init();
    }

    public int init() {
        int id = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                ArrayList<String> rowA = new ArrayList<>();
                Collections.addAll(rowA, st.split(",", columns));

                if (rowA.get(0).length() == 1)
                    id = Integer.parseInt(rowA.get(0));

                database.add(rowA);
            }

            if (database.size() > 0) {
                headers.addAll(database.get(0));
                database.remove(0);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("No se pudo conectar con la base de datos");
        }
        return id;
    }

    /**
     * @return ArrayList<ArrayList < String>>
     */
    public ArrayList<ArrayList<String>> getDatabase() {
        return new ArrayList<>(database);
    }

    public void save() {
        try {
            FileWriter myWriter = new FileWriter(file);
            StringBuilder h = new StringBuilder();
            for (int i = 0; i < headers.size(); i++) {
                if (i == headers.size() - 1)
                    h.append(headers.get(i));
                else
                    h.append(headers.get(i)).append(",");
            }
            myWriter.write(h + "\n");
            for (int k = 0; k < database.size(); k++) {
                StringBuilder rowT = new StringBuilder();
                for (int i = 0; i < database.get(k).size(); i++) {
                    String arrayList = database.get(k).get(i);
                    if (i == database.get(0).size() - 1)
                        rowT.append(arrayList);
                    else
                        rowT.append(arrayList).append(",");
                }
                myWriter.write(rowT.toString());

                if (k != database.size() - 1)
                    myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * @return String
     */
    public String toString() {
        StringBuilder result = new StringBuilder(
                "| " + headers.toString().replace(",", " | ").replace("[", "").replace("]", "") + " |");

        for (ArrayList<String> strings : database)
            result.append("\n").append(strings.toString().replace("[", "").replace("]", ""));

        return result.toString();
    }
}
