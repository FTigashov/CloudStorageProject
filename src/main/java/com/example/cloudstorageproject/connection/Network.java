package com.example.cloudstorageproject.connection;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.net.Socket;

public class Network {
    private static Socket socket;
    private static ObjectEncoderOutputStream outcomingStream;
    private static ObjectDecoderInputStream incomingStream;

    public static void openConnection() {
        try {
            socket = new Socket("localhost", 45001);
            outcomingStream = new ObjectEncoderOutputStream(socket.getOutputStream());
            incomingStream = new ObjectDecoderInputStream(socket.getInputStream(), 20 * 1_000_000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean sendAuthMessage(String login, String password) {
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

    public static boolean sendRegisterMessage(String login, String password) {
        try {
            outcomingStream.writeObject(new RegisterMessageSet(login, password));
            outcomingStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
