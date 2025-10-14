package com.example.kngurosgym.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasenia;

    @FXML
    private void abrirIniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + contrasenia);

        if(usuario.isEmpty() || contrasenia.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor complete todos los campos");
            alert.showAndWait();
        } else {

        }
    }

    @FXML
    private void abrirCrearUsuario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kngurosgym/crear-usuario-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
