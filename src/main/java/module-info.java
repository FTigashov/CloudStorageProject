module com.example.cloudstorageproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires io.netty.transport;
    requires io.netty.buffer;


    opens com.example.cloudstorageproject to javafx.fxml;
    exports com.example.cloudstorageproject.client.models;
    exports com.example.cloudstorageproject.client.controllers;
    opens com.example.cloudstorageproject.client.controllers to javafx.fxml;
    exports com.example.cloudstorageproject.client;
    exports com.example.cloudstorageproject.server;
    exports com.example.cloudstorageproject.server.handlers;
    opens com.example.cloudstorageproject.client to javafx.fxml;
}