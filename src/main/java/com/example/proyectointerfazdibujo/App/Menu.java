package com.example.proyectointerfazdibujo.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("/com/example/proyectointerfazdibujo/Menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);

        stage.setTitle("ProyectoInterfazDibujo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}