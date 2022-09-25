package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartClient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField pwdField;

    @FXML
    void openRegisterPage(MouseEvent event) {
        startClient.openRegisterScene();
    }
    private StartClient startClient;

    public void setStartApp(StartClient startClient) {
        this.startClient = startClient;
    }

    @FXML
    void startAuth(MouseEvent event) {
        if (loginField.getText().trim().length() == 0 || pwdField.getText().trim().length() == 0) {
            startClient.showEmptyErrorMessage("login");
        }
    }

}