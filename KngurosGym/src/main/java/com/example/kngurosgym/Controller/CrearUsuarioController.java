package com.example.kngurosgym.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.regex.Pattern;

public class CrearUsuarioController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasenia;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEdad;
    @FXML private ComboBox<String> cbSexo;
    @FXML private TextField txtAltura;
    @FXML private TextField txtPeso;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @FXML
    public void initialize() {
        ObservableList<String> opcionesSexo = FXCollections.observableArrayList("M", "F");
        cbSexo.setItems(opcionesSexo);
    }

    @FXML
    private void clickGuardar() {
        System.out.println("Creando cuenta...");

        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        String sexo = cbSexo.getValue();
        String altura = txtAltura.getText();
        String peso = txtPeso.getText();

        if(usuario.isEmpty() || contrasenia.isEmpty() || email.isEmpty() ||
                edad.isEmpty() || sexo == null || altura.isEmpty() || peso.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor complete todos los campos");
            alert.showAndWait();
            return;
        }

        if(!isValidEmail(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email inválido");
            alert.setContentText("Por favor ingrese un email válido");
            alert.showAndWait();
            return;
        }
        try {
            int edadNum = Integer.parseInt(edad);
            double alturaNum = Double.parseDouble(altura);
            double pesoNum = Double.parseDouble(peso);

            if(edadNum < 15 || edadNum > 100) {
                throw new NumberFormatException("Edad fuera de rango");
            }
            if(alturaNum < 100 || alturaNum > 250) {
                throw new NumberFormatException("Altura fuera de rango");
            }
            if(pesoNum < 30 || pesoNum > 300) {
                throw new NumberFormatException("Peso fuera de rango");
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Datos numéricos inválidos");
            alert.setContentText("Por favor ingrese valores numéricos válidos para edad, altura y peso:\n" +
                    "- Edad: entre 15 y 100 años\n" +
                    "- Altura: entre 100 y 250 cm\n" +
                    "- Peso: entre 30 y 300 kg");
            alert.showAndWait();
            return;
        }

        System.out.println("Usuario: " + usuario);
        System.out.println("Email: " + email);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText("Cuenta creada");
        alert.setContentText("La cuenta se ha creado correctamente");
        alert.showAndWait();

    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    @FXML
    private void abrirRegresarCuenta(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kngurosgym/inicio-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
