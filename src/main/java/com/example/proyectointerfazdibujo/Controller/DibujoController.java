package com.example.proyectointerfazdibujo.Controller;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.DrawMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DibujoController {

    @FXML
    private Canvas canvas;
    @FXML
    private ComboBox<String> CBox;
    @FXML
    private AnchorPane MAjustes;
    String valor;
    private GraphicsContext gc;
    private Image texture;
    @FXML
    public void formato() {
        valor = CBox.getValue();
    }
    @FXML
    private void Pincel(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/texturaPincel.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    @FXML
    private void guardar(){
        if (Objects.equals(valor, "PNG")){
            WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
            canvas.snapshot(null, writableImage);
            // Guardar la imagen en un archivo
            File file = new File("canvasImage.png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                System.out.println("Imagen guardada como: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar la imagen: " + e.getMessage());
            }
        } else if (Objects.equals(valor,"JPEG")) {
            WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
            canvas.snapshot(null, writableImage);
            // Guardar la imagen en un archivo
            File file = new File("canvasImage.jpeg");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "jpeg", file);
                System.out.println("Imagen guardada como: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar la imagen: " + e.getMessage());
            }
        } else if (Objects.equals(valor,"SVG")) {
            WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
            canvas.snapshot(null, writableImage);
            // Guardar la imagen en un archivo
            File file = new File("canvasImage.svg");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "svg", file);
                System.out.println("Imagen guardada como: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar la imagen: " + e.getMessage());
            }
        }
    }
    @FXML
    private void Lapiz(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/texturaLapiz.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    @FXML
    private void Pluma(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/texturaPluma.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    @FXML
    private void Borrador(){
        gc = canvas.getGraphicsContext2D();
        texture = new Image(getClass().getResourceAsStream("/Imagenes/Blanco.png"));
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::presionarMause);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::arratrarMause);
    }
    @FXML
    private void MAjustes() {
        MAjustes.setVisible(true);
        TranslateTransition tT4 = new TranslateTransition(Duration.seconds(1.5),MAjustes);
        tT4.setByY(-50);
        tT4.setAutoReverse(true);
        tT4.play();
        FadeTransition fT4 = new FadeTransition(Duration.seconds(2),MAjustes);
        fT4.setFromValue(0);
        fT4.setToValue(1);
        fT4.play();
    }
    @FXML
    private void MAjustesCerrar() throws InvalidMidiDataException {
        TranslateTransition tT4 = new TranslateTransition(Duration.seconds(1.5),MAjustes);
        tT4.setByY(50);
        tT4.setAutoReverse(true);
        tT4.play();
        FadeTransition fT4 = new FadeTransition(Duration.seconds(2),MAjustes);
        fT4.setFromValue(1);
        fT4.setToValue(0);
        fT4.play();
        SequentialTransition sequence = new SequentialTransition(tT4, fT4);
        sequence.setOnFinished(e -> {
            MAjustes.setOpacity(0);
            canvas.setVisible(true);
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
    @FXML
    protected void initialize() {
        CBox.getItems().addAll("PNG", "JPEG", "SVG");
        MAjustes.setVisible(false);
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
    private void saveCanvasAsImage(Canvas canvas) {
        WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.snapshot(null, writableImage);
        // Guardar la imagen en un archivo
        File file = new File("canvasImage.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("Imagen guardada como: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}