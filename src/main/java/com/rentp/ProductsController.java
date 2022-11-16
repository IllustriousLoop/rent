package com.rentp;

import com.rentp.Database.DatabaseCars;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ProductsController {
    @FXML
    public GridPane tableMain;
    public Text data;

    @FXML
    public void initialize() {
        DatabaseCars dbCars = new DatabaseCars();
        ArrayList<ArrayList<String>> cars = dbCars.getDatabase();

        int j = 0;
        int k = 0;
        for (int i = 0; i < cars.size(); i++) {
            ArrayList<String> car = cars.get(i);
            Image image1 = new Image(getClass().getResourceAsStream("img/" + car.get(2)));

            if (i == 2) {
                j++;
                k = 0;
            }

            VBox container = new VBox(20);
            container.getStyleClass().add("panel");
            container.getStyleClass().add("panel-primary");

            HBox header = new HBox(20);
            header.getStyleClass().add("panel-heading");
            Text Brand = new Text(car.get(1));
            Brand.getStyleClass().add("panel-title");

            HBox body = new HBox(20);
            Text horse = new Text(car.get(3));
            ImageView imageView1 = new ImageView(image1);
            container.getStyleClass().add("panel-body");
            imageView1.setFitWidth(250);
            imageView1.setFitHeight(250);

            header.getChildren().add(Brand);
            body.getChildren().add(horse);
            body.getChildren().add(imageView1);

            container.getChildren().add(header);
            container.getChildren().add(body);

            tableMain.add(container, k, j, 1, 1);
            tableMain.setHgap(5);
            tableMain.setVgap(5);

            k++;
        }
    }
}
