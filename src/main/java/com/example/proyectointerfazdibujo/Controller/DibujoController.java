package com.example.proyectointerfazdibujo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class DibujoController {
    @FXML
    private Button BPincel;
    @FXML
    private Button BLapiz;
    @FXML
    private Button BPluma;
    @FXML
    private Button BFiguras;
    @FXML
    private Button BBorrador;
    @FXML
    private Button BInicio;
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Image texture;

    private void Pincel(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/texturaPincel.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    private void Lapiz(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/texturaLapiz.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    @FXML
    protected void initialize() {

        BPincel.setOnAction(e -> Pincel());
        BLapiz.setOnAction(e -> Lapiz());
        BBorrador.setOnAction(null);
        BInicio.setOnAction(event -> {
            try {
                irInicio(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    protected void irInicio(ActionEvent event) throws IOException {
        Object o = event.getSource();
        Node node = (Node) o;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyectointerfazdibujo/Menu-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
    }


    private void presionarMause(MouseEvent event) {
        dibujarTextura(event.getX(), event.getY());
    }
    private void arratrarMause(MouseEvent event) {
        dibujarTextura(event.getX(), event.getY());
    }
    private void dibujarTextura(double x, double y) {
        gc.drawImage(texture, x, y, texture.getWidth(), texture.getHeight());
    }
}