package com.example.kngurosgym.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgresoController {

    private String previousView;

    public void setPreviousView(String previousView) {
        this.previousView = previousView;
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {

        String viewToLoad = (previousView != null) ? previousView : "/com/example/kngurosgym/cardio-view.fxml";

        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewToLoad));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void verHistorial(ActionEvent event) {
        System.out.println("Historial seleccionado (por implementar)");
    }

    @FXML
    private void actualizarPeso(ActionEvent event) {
        System.out.println("Actualizar peso seleccionado (por implementar)");
    }
}

