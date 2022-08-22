module com.example.cloudstorageproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cloudstorageproject to javafx.fxml;
    exports com.example.cloudstorageproject;
}