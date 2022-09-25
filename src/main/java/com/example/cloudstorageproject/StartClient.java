package com.example.cloudstorageproject;

import com.example.cloudstorageproject.controllers.RegistrationController;
import com.example.cloudstorageproject.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class StartClient extends Application {
    Stage mainStage;
    Scene loginScene;
    Scene registerScene;

    LoginController loginController;
    RegistrationController registrationController;

    @Override
    public void start(Stage stage) throws Exception {
        this.mainStage = stage;

        createLoginScene();
        createRegisterScene();

        // Первоначальные настройки основной сцены
        mainStage.setScene(loginScene);
        mainStage.setResizable(false);
        mainStage.setTitle("Cloud Storage Program");
        mainStage.centerOnScreen();
        mainStage.show();
    }

    // Переключение на авторизацию
    private void createLoginScene() throws IOException {
        FXMLLoader loginSceneLoader = new FXMLLoader(getClass().getResource("auth-view.fxml"));
        loginScene = new Scene(loginSceneLoader.load());
        loginController = loginSceneLoader.getController();
        loginController.setStartApp(this);
    }

    // Переключение на регистрацию
    private void createRegisterScene() throws IOException {
        FXMLLoader registerSceneLoader = new FXMLLoader(getClass().getResource("reg-view.fxml"));
        registerScene = new Scene(registerSceneLoader.load());
        registrationController = registerSceneLoader.getController();
        registrationController.setStartApp(this);
    }

    public static void main(String[] args) {
        launch();
    }

    public void openRegisterScene() {
        mainStage.setScene(registerScene);
    }

    public void openLoginScene() {
        mainStage.setScene(loginScene);
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