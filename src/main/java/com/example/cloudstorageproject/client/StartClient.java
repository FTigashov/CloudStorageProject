package com.example.cloudstorageproject.client;

import com.example.cloudstorageproject.client.controllers.RegistrationController;
import com.example.cloudstorageproject.client.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class StartClient extends Application {
    private Stage stage;
    private Scene loginScene;
    private Scene registerScene;

    private LoginController loginController;
    private RegistrationController registrationController;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        loginScene = createLoginScene();
        registerScene = createRegisterScene();

        // Первоначальные настройки основной сцены
        stage.setResizable(false);
        stage.setTitle("Cloud Storage Program beta 0.5");
        stage.centerOnScreen();
        stage.show();
    }

    // Переключение на авторизацию
    private Scene createLoginScene() throws IOException {
        FXMLLoader loginLoader = FXMLLoader.load(getClass().getClassLoader().getResource("startView.fxml"));
        return loginScene;
    }

    // Переключение на регистрацию
    private Scene createRegisterScene() throws IOException {
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

    public void showEmptyErrorMessage(String type) {
        String title = "";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (type.equals("reg")) title = "Ошибка регистрации";
        else if (type.equals("login")) title = "Ошибка авторизации";
        alert.setTitle(title);
        alert.setHeaderText("Необходимо, чтобы все поля были заполнены!");
        alert.show();
    }
}