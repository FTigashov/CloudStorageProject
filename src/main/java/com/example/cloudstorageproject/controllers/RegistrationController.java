package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartApp;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class RegistrationController {
    @FXML
    void backToLoginScene(MouseEvent event) {
        startApp.openLoginScene();
    }
    private StartApp startApp;

    public void setStartApp(StartApp startApp) {
        this.startApp = startApp;
    }
}
