module com.project.quadradomagico {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.quadradomagico to javafx.fxml;
    exports com.project.quadradomagico;
}