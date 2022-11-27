package com.fastu.fastu.Controladores;

import com.fastu.fastu.Controladores.MenuController;
import com.fastu.fastu.FastU;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import java.io.IOException;
import java.util.Objects;


public class QuejasController {

    Stage stage = new Stage();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private String descripcion;

    @FXML
    private RadioButton check1;

    @FXML
    private RadioButton check2;

    @FXML
    private RadioButton check3;

    @FXML
    private Button enviar;

    @FXML
    private TextArea especificar;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public QuejasController(String descripcion, RadioButton check1, RadioButton check2, RadioButton check3, Button enviar, TextArea especificar) {
        this.descripcion = descripcion;
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
        this.enviar = enviar;
        this.especificar = especificar;
    }

    public String getDescripcion() {
        return descripcion;
    }


    @FXML
    void check1(ActionEvent event) {
        //"Problema con el domiciliario"
    }

    @FXML
    void check2(ActionEvent event) {
        //"Problema con el producto pedido"
    }

    @FXML
    void check3(ActionEvent event) {
        //"Problema de la aplicacion"
    }


    @FXML
    void BotonEnviar(ActionEvent event) throws IOException {

        String descripcion = especificar.getText();

        File archivo = new File("queja.txt");

        if (archivo.exists()) {
            try {
                FileWriter escribir = new FileWriter(archivo, true);
                escribir.write("\n"+descripcion);
                escribir.close();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("No se pudo abrir el archivo!");
            }
        } else {
            try {
                archivo.createNewFile();
                FileWriter escribir = new FileWriter(archivo, true);
                escribir.write(descripcion);
                escribir.close();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("No se pudo abrir el archivo!");
            }
        }

        FXMLLoader loader = new FXMLLoader(FastU.class.getResource("FXML/menu.fxml"));
        Scene scene = new Scene(loader.load(), 375, 667);
        MenuController controller = loader.getController();
        Stage nStage = new Stage();
        nStage.setTitle("Menu");
        nStage.setScene(scene);
        nStage.getIcons().add(new Image(Objects.requireNonNull(FastU.class.getResourceAsStream("logo.png"))));
        controller.setStage(nStage);
        nStage.show();
        this.stage.close();
    }



}