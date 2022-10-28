package com.rentp.rent;

import com.rentp.Database.DatabaseUsers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HomeController {
    @FXML
    public TextField Email;
    public Label EmailLabel;
    public Label PasswordLabel;
    public TextField Password;

    @FXML
    protected void onSignInButtonClick() {
        String e = Email.getText();
        String p = Password.getText();
        DatabaseUsers dbUsers = new DatabaseUsers();

        boolean auth = dbUsers.auth(e, p);
        if (auth) {
            System.out.println("Hello Welcome!");
        }
    }

    @FXML
    protected void onSignUpButtonClick() {
    }
}