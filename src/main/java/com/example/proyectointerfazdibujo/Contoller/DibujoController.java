package com.example.proyectointerfazdibujo.Contoller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

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