package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartApp;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    void openRegisterPage(MouseEvent event) {
        startApp.openRegisterScene();
    }
    private StartApp startApp;

    public void setStartApp(StartApp startApp) {
        this.startApp = startApp;
    }
}