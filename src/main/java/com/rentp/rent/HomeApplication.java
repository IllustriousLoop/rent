package com.rentp.rent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Rent my auto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

//DatabaseCars dbCars = new DatabaseCars();
// dbUsers.addNewUser("Jhair", "Paris", "jhair@jhairparis.com","Hola");
// dbCars.addNewCar("Renault", "Things", "Hello");
// db.modifyById(2, "Hello", null, null);
// dbUsers.deleteById(0);
// System.out.println(dbUsers);
//System.out.println(dbCars);
// dbCars.save();
// dbUsers.save();