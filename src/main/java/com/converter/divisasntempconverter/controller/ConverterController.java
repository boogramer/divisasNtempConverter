package com.converter.divisasntempconverter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML
    private Tab bienvenido_tab;

    @FXML
    private Tab convDiv_tab;

    @FXML
    private Tab convTemp_tab;

    @FXML
    private TabPane dashboard_tp;

    @FXML
    private TextField inputMoneda_txtfield;

    @FXML
    private ImageView intercambiarMoneda_img;

    @FXML
    private StackPane mainDashboard_Sp;

    @FXML
    private ChoiceBox<String> monedaDestino_choicebx;

    @FXML
    private ChoiceBox<String> monedaOr_choicebx;

    @FXML
    private TextField outputMoneda_txtfield;
    @FXML
    private Button intercambiarMoneda_button;
    @FXML
    private Button convertir_button;

    private final String[] moneda = {"PEN S/. - Nuevo Sol Peruano", "USD $ - Dólar Estadounidense", "EUR € - Euro", "JYP ¥ - Yen Japonés", "KRW ₩ - Won Surcoreano", "GBP £ - Libra Esterlina"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //meter todo esto en una clase o metodo
        monedaOr_choicebx.getItems().addAll(moneda);
        monedaOr_choicebx.setValue("PEN S/. - Nuevo Sol Peruano");
        monedaDestino_choicebx.getItems().addAll(moneda);
        monedaDestino_choicebx.setValue("USD $ - Dólar Estadounidense");

        intercambiarMoneda_button.setOnAction(this::swapCurrency);
        convertir_button.setOnAction(this::exchangeCurrency);

    }

    /**
     * Este metodo nos permitira intercambiar los simbolos de las mendas para que la conversion se reversible
     * @param event
     */
    public void swapCurrency(ActionEvent event){
        String monedaDes = monedaDestino_choicebx.getValue();
        String monedaOr = monedaOr_choicebx.getValue();
        monedaOr_choicebx.setValue(monedaDes);
        monedaDestino_choicebx.setValue(monedaOr);
    }

    /**
     * Este metodo nos permitira ejecutar la coonversion
     * @param event
     */
    public void exchangeCurrency(ActionEvent event) {
        String monedaDes = monedaDestino_choicebx.getValue();
        String monedaOr = monedaOr_choicebx.getValue();

        /*switch () {
        }*/
    }
}