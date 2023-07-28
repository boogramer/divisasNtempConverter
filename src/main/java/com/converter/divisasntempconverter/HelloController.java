package com.converter.divisasntempconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
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

    private final String[] moneda = {"PEN S/. - Nuevo Sol Peruano", "USD $ - Dólar Estadounidense", "EUR € - Euro", "JYP ¥ - Yen Japonés", "KRW ₩ - Won Surcoreano", "GBP £ - Libra Esterlina"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monedaOr_choicebx.getItems().addAll(moneda);
        monedaOr_choicebx.setValue("PEN S/. - Nuevo Sol Peruano");
        monedaDestino_choicebx.getItems().addAll(moneda);
        monedaDestino_choicebx.setValue("USD $ - Dólar Estadounidense");

        intercambiarMoneda_button.setOnAction(this::intercambiarDivisas);

    }
    public void intercambiarDivisas(ActionEvent event){
        String monedaDes = monedaDestino_choicebx.getValue();
        String monedaOr = monedaOr_choicebx.getValue();
        monedaOr_choicebx.setValue(monedaDes);
        monedaDestino_choicebx.setValue(monedaOr);
    }
}