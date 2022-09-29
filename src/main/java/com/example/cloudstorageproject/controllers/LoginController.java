package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartClient;
import com.example.cloudstorageproject.connection.Network;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private Button loginBtn;
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField pwdField;

    @FXML
    void openRegisterPage(MouseEvent event) {
        startClient.switchScene(1);
    }
    private StartClient startClient;
    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setStartApp(StartClient startClient) {
        this.startClient = startClient;
    }

    @FXML
    void startAuth(MouseEvent event) {
        if (loginField.getText().trim().length() == 0 || pwdField.getText().trim().length() == 0) {
            startClient.showEmptyErrorMessage(0);
        } else {
            String login = loginField.getText().trim();
            String password = hashPassword(pwdField.getText().trim());
            network.openConnection();
            network.sendAuthMessage(login, password);
        }
    }

    // Хэширование строки
    public String hashPassword(String stringToHash) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(stringToHash.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    Thread loginControllerListener = new Thread(() -> {
        for (;;) {
            Object messageFromServer = null;
            try {
                messageFromServer = network.readMessageFromServer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (messageFromServer.toString().startsWith("correctUserData/")) {
                System.out.println("Пользователь зарегистрирован");
                startClient.switchScene(0);
            }
        }
    });
}