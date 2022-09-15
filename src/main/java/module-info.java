module com.example.cloudstorageproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires io.netty.transport;
    requires io.netty.buffer;


    opens com.example.cloudstorageproject to javafx.fxml;
    exports com.example.cloudstorageproject;
    exports com.example.cloudstorageproject.client.controllers;
    opens com.example.cloudstorageproject.client.controllers to javafx.fxml;
    exports com.example.cloudstorageproject.client;
    opens com.example.cloudstorageproject.client to javafx.fxml;
}