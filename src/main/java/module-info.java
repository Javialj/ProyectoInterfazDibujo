module com.example.proyectointerfazdibujo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectointerfazdibujo to javafx.fxml;
    exports com.example.proyectointerfazdibujo.App;
    opens com.example.proyectointerfazdibujo.App to javafx.fxml;
    exports com.example.proyectointerfazdibujo.Contoller;
    opens com.example.proyectointerfazdibujo.Contoller to javafx.fxml;
}