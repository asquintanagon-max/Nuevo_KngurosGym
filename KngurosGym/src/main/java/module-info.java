module com.example.kngurosgym {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kngurosgym to javafx.fxml;
    exports com.example.kngurosgym;
    exports com.example.kngurosgym.Controller;
    opens com.example.kngurosgym.Controller to javafx.fxml;
}