package com.example.proyectointerfazdibujo.Controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button BDibujar;
    @FXML
    private Button BAjustes;
    @FXML
    private Button BCerrar;
    @FXML
    private Label LArt;
    @FXML
    private AnchorPane AFondo;
    @FXML
    private Pane MAjustes;

    private void MAjustes() {
        MAjustes.setVisible(true);
        TranslateTransition tT4 = new TranslateTransition(Duration.seconds(1.5),MAjustes);
        tT4.setByY(-50);
        tT4.setAutoReverse(true);
        tT4.play();
        FadeTransition fT4 = new FadeTransition(Duration.seconds(2),MAjustes);
        fT4.play();
    }
    private void Translate(){
        TranslateTransition tT1 = new TranslateTransition(Duration.seconds(1.5),BDibujar);
        tT1.setByY(-40);
        tT1.setAutoReverse(true);
        tT1.play();
        TranslateTransition tT2 = new TranslateTransition(Duration.seconds(1.5),BAjustes);
        tT2.setByY(-40);
        tT2.setAutoReverse(true);
        tT2.play();
        TranslateTransition tT3 = new TranslateTransition(Duration.seconds(1.5),LArt);
        tT3.setByY(-40);
        tT3.setAutoReverse(true);
        tT3.play();
    }
    private void Aparicion(){
        FadeTransition fT1 = new FadeTransition(Duration.seconds(2),BDibujar);
        fT1.setFromValue(0);
        fT1.setToValue(1);
        fT1.play();
        FadeTransition fT2 = new FadeTransition(Duration.seconds(2),BAjustes);
        fT2.setFromValue(0);
        fT2.setToValue(1);
        fT2.play();
        FadeTransition fT3 = new FadeTransition(Duration.seconds(2),LArt);
        fT3.setFromValue(0);
        fT3.setToValue(1);
        fT3.play();
    }

    @FXML
    protected void initialize() {
        Translate();
        Aparicion();
        MAjustes.setVisible(false);
        BAjustes.setOnAction(e -> MAjustes());
        BDibujar.setOnAction(event -> {
            try {
                irDibujo(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        BCerrar.setOnAction(e -> MAjustes.setVisible(false));
    }
    @FXML
    protected void irDibujo(ActionEvent event) throws IOException {
        Object o = event.getSource();
        Node node = (Node) o;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/proyectointerfazdibujo/Dibujo-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
    }



}