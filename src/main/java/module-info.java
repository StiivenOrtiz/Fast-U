module com.fastu.fastu {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.fastu.fastu to javafx.fxml;
    opens com.fastu.fastu.Modelo to javafx.fxml;
    opens com.fastu.fastu.Controladores to javafx.fxml;
    exports com.fastu.fastu;
    exports com.fastu.fastu.Controladores;
    exports com.fastu.fastu.Modelo;
}