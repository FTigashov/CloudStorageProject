package com.example.cloudstorageproject.controllers;

import com.example.cloudstorageproject.StartClient;
import com.example.cloudstorageproject.connection.Network;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistrationController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField pwdField;

    @FXML
    private PasswordField confirmPwd;
    @FXML
    private Button registerBtn;

    @FXML
    void backToLoginScene(MouseEvent event) {
        startClient.switchScene(0);
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
    void startRegistration(MouseEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (loginField.getText().length() == 0 ||
        pwdField.getText().length() == 0 || confirmPwd.getText().length() == 0) {
            startClient.showEmptyErrorMessage(1);
        } else {
            if (pwdField.getText().trim().equals(confirmPwd.getText().trim())) {
                StringBuilder hashPassword = hashPassword(pwdField.getText().trim());
                Network.sendRegisterMessage(loginField.getText().trim(), hashPassword.toString());
            } else {
                startClient.showEmptyErrorMessage(-1);
            }
        }
    }


    // Хэширование строки
    public StringBuilder hashPassword(String stringToHash) {
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
        return hexString;
    }
}
