package com.rentp;

import java.io.IOException;
import javafx.fxml.FXML;
import com.rentp.Database.DatabaseUsers;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SignInController {
    @FXML
    public TextField Email;
    public Label EmailLabel;
    public Label PasswordLabel;
    public PasswordField Password;
    public VBox singIn;
    public VBox singUp;

    private void showAlertWithHeaderText(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void onSignInButtonClick() throws IOException {
        String e = Email.getText();
        String p = Password.getText();

        if (e.isEmpty() || p.isEmpty()) {
            showAlertWithHeaderText("Input empty", "insert value for email and password");
            return;
        }

        DatabaseUsers dbUsers = new DatabaseUsers();
        boolean auth = dbUsers.auth(e, p);
        if (auth) {
            App.setRoot("Products");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("SignUp");
    }
}
