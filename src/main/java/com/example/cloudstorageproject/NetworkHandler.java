package com.example.cloudstorageproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.sun.jndi.ldap.LdapCtx.DEFAULT_HOST;
import static com.sun.jndi.ldap.LdapCtx.DEFAULT_PORT;

public class NetworkHandler {

    private DataInputStream in;
    private DataOutputStream out;

    private final String host;
    private final int port;
    private String username;

    public NetworkHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public NetworkHandler() {
        this.host = DEFAULT_HOST;
        this.port = DEFAULT_PORT;
    }

    public void connect() {
        try {
            Socket socket = new Socket(host, port);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Соединение не установлено");
        }
    }

    public DataOutputStream getOut() {
        return out;
    }
}
