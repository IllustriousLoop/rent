package com.rentp;

import java.io.IOException;
import javafx.fxml.FXML;

public class SignUpController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("SignIn");
    }
}