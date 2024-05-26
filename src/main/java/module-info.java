module com.example.proyectointerfazdibujo {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.proyectointerfazdibujo to javafx.fxml;
    exports com.example.proyectointerfazdibujo.App;
    opens com.example.proyectointerfazdibujo.App to javafx.fxml;
    exports com.example.proyectointerfazdibujo.Controller;
    opens com.example.proyectointerfazdibujo.Controller to javafx.fxml;
}