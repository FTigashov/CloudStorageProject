package com.example.cloudstorageproject;

import com.example.cloudstorageproject.controllers.RegistrationController;
import com.example.cloudstorageproject.controllers.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApp extends Application {
    private Stage stage;

    private Scene loginScene;
    private Scene registerScene;

    private StartController startController;
    private RegistrationController registrationController;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        loginScene = createLoginScene();
        registerScene = createRegisterScene();

        // Первоначальные настройки основной сцены
        stage.centerOnScreen();
        stage.setScene(loginScene);
        stage.setTitle("Cloud Storage Program beta 0.1");
        stage.show();
    }


    // Переключение на авторизацию
    private Scene createLoginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("startView.fxml"));
        loginScene = new Scene(fxmlLoader.load());
        startController = fxmlLoader.getController();
        return loginScene;
    }

    // Переключение на регистрацию
    private Scene createRegisterScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("registrationView.fxml"));
        registerScene = new Scene(fxmlLoader.load());
        registrationController = fxmlLoader.getController();
        return registerScene;
    }

    public static void main(String[] args) {
        launch();
    }
}