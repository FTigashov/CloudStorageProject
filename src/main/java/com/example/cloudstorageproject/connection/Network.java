package com.example.cloudstorageproject.connection;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.net.Socket;

public class Network {
    private Socket socket;
    private ObjectEncoderOutputStream outcomingStream;
    private ObjectDecoderInputStream incomingStream;

    private String HOST_NAME = "localhost";
    private int PORT = 45001;
    private int MAX_SIZE = 20 * 1_000_000;

    public void openConnection() {
        try {
            socket = new Socket(HOST_NAME, PORT);
            outcomingStream = new ObjectEncoderOutputStream(socket.getOutputStream());
            incomingStream = new ObjectDecoderInputStream(socket.getInputStream(), MAX_SIZE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean sendAuthMessage(String login, String password) {
        try {
            // TODO
            outcomingStream.writeObject(new AuthMessageSet(login, password));
            outcomingStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendRegisterMessage(String login, String password) {
        try {
            outcomingStream.writeObject(new RegisterMessageSet(login, password));
            outcomingStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object readMessageFromServer() {
        Object object = null;
        try {
            object = incomingStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
