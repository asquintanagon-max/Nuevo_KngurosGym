package com.example.kngurosgym.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class PrincipalController {

    private Stage stage;
    private Scene scene;

    private void changeScene(String fxmlFile, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToCardio(ActionEvent event) throws IOException {
        changeScene("/com/example/kngurosgym/cardio-view.fxml", event);
    }

    @FXML
    public void goToSuperior(ActionEvent event) throws IOException {
        changeScene("/com/example/kngurosgym/superior-view.fxml", event);
    }

    @FXML
    public void goToInferior(ActionEvent event) throws IOException {
        changeScene("/com/example/kngurosgym/inferior-view.fxml", event);
    }
}

