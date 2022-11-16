package com.rentp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("SignIn"), 640, 480);

        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.sizeToScene();
        stage.setTitle("Rent my auto");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
// dbUsers.addNewUser("Jhair", "Paris", "jhair@jhairparis.com","Hola");
// dbUsers.deleteById(0);
// dbUsers.save();
// System.out.println(dbUsers);