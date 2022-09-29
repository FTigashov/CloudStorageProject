module com.example.cloudstorageproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires io.netty.transport;
    requires io.netty.buffer;
    requires io.netty.codec;
    requires java.sql;


    opens com.example.cloudstorageproject to javafx.fxml;
    exports com.example.cloudstorageproject.controllers;
    opens com.example.cloudstorageproject.controllers to javafx.fxml;
    exports com.example.cloudstorageproject;
}