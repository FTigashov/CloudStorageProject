package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegistrationController {

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField fatherNameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField pwdField;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField secondNameField;
    @FXML
    void backToLoginScene(MouseEvent event) {
        startApp.openLoginScene();
    }
    private StartApp startApp;

    public void setStartApp(StartApp startApp) {
        this.startApp = startApp;
    }

    @FXML
    void startRegistration(MouseEvent event) {
        if (secondNameField.getText().length() == 0 ||
        nameField.getText().length() == 0 ||
        fatherNameField.getText().length() == 0 ||
        loginField.getText().length() == 0 ||
        pwdField.getText().length() == 0) {
            startApp.showEmptyErrorMessage("reg");
        }
    }
}
