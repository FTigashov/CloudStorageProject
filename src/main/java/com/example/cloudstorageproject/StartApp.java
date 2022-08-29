package com.example.cloudstorageproject;

import com.example.cloudstorageproject.controllers.RegistrationController;
import com.example.cloudstorageproject.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StartApp extends Application {
    private Stage stage;

    private Scene loginScene;
    private Scene registerScene;

    private LoginController loginController;
    private RegistrationController registrationController;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        loginScene = createLoginScene();
        registerScene = createRegisterScene();

        // Первоначальные настройки основной сцены
        stage.centerOnScreen();
        stage.setScene(loginScene);
        stage.setResizable(false);
        stage.setTitle("Cloud Storage Program beta 0.1");
        stage.show();
    }

    // Переключение на авторизацию
    private Scene createLoginScene() throws IOException {
        URL location = getClass().getResource("authenticationViews/startView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        loginScene = new Scene(fxmlLoader.load());
        loginController = fxmlLoader.getController();
        loginController.setStartApp(this);
        return loginScene;
    }

    // Переключение на регистрацию
    private Scene createRegisterScene() throws IOException {
        URL location = getClass().getResource("authenticationViews/registrationView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        registerScene = new Scene(fxmlLoader.load());
        registrationController = fxmlLoader.getController();
        registrationController.setStartApp(this);
        return registerScene;
    }

    public static void main(String[] args) {
        launch();
    }

    public void openRegisterScene() {
        stage.setScene(registerScene);
    }

    public void openLoginScene() {
        stage.setScene(loginScene);
    }
}