package com.example.proyectointerfazdibujo.Contoller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MenuController {
    @FXML
    private Button BDibujar;
    @FXML
    private Button BAjustes;
    @FXML
    private Label LArt;
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
    }
}