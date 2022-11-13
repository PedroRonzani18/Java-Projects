module com.example.graphiccontabilidade {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graphiccontabilidade to javafx.fxml;
    exports com.example.graphiccontabilidade;
}