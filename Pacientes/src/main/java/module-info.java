module com.example.pacientes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pacientes to javafx.fxml;
    exports com.example.pacientes;
}