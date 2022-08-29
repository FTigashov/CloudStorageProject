module com.example.cloudstorageproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;


    opens com.example.cloudstorageproject to javafx.fxml;
    exports com.example.cloudstorageproject;
    exports com.example.cloudstorageproject.controllers;
    opens com.example.cloudstorageproject.controllers to javafx.fxml;
}