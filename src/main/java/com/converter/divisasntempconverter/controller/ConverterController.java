package com.converter.divisasntempconverter.controller;

import com.converter.divisasntempconverter.conectionAPI.ConectionToAPI;
import com.converter.divisasntempconverter.conectionAPI.JsonConversion;
import com.converter.divisasntempconverter.models.Currency;
import com.converter.divisasntempconverter.respositories.Converter;
import com.converter.divisasntempconverter.respositories.ConverterImp;
import com.converter.divisasntempconverter.services.CurrencyService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

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
    private ComboBox<String> monedaOrigen_comboBox;

    @FXML
    private ComboBox<String> monedaDestino_comboBox;

    @FXML
    private TextField outputMoneda_txtfield;
    @FXML
    private Button intercambiarMoneda_button;
    @FXML
    private Button convertir_button;
    CurrencyService currencyService;
    List<Currency> listCurrency;
    //private final String[] moneda = {"PEN S/. - Nuevo Sol Peruano", "USD $ - Dólar Estadounidense", "EUR € - Euro", "JYP ¥ - Yen Japonés", "KRW ₩ - Won Surcoreano", "GBP £ - Libra Esterlina"};

    @Override
    public void initialize(URL uri, ResourceBundle resourceBundle) {
        //meter todo esto en una clase o metodo
        //monedaOrigen_comboBox.getItems().addAll(moneda);
        //monedaOrigen_comboBox.setValue("PEN S/. - Nuevo Sol Peruano");
        //monedaDestino_comboBox.getItems().addAll(moneda);
        //monedaDestino_comboBox.setValue("USD $ - Dólar Estadounidense");

        intercambiarMoneda_button.setOnAction(this::swapCurrency);
        //exchangeSymbol();

        // implemetnacon de la API
        try {
            String url = "https://api.apilayer.com/fixer";
            String apiKey = "esPBXLyRPRajzavpmV6bfPFFbkCRkoCF";
            ConectionToAPI contectiontoApi = new ConectionToAPI(url, apiKey);
            JsonConversion jsonConversion = new JsonConversion();
            Converter converter = new ConverterImp(contectiontoApi, jsonConversion);
            currencyService = new CurrencyService(converter);

            listCurrency = currencyService.getAllCurrencies();
            List<String> listSymbols = currencyService.getAllSymbols(listCurrency);
            List<String> listSignification = currencyService.getSignification(listCurrency);

            listSymbolNsignification(listCurrency, monedaOrigen_comboBox);
            monedaOrigen_comboBox.setVisibleRowCount(5);
            monedaOrigen_comboBox.setEditable(false);

            listSymbolNsignification(listCurrency, monedaDestino_comboBox);
            monedaDestino_comboBox.setVisibleRowCount(5);
            monedaDestino_comboBox.setEditable(false);
        } catch (IOException ex) {
            Logger.getLogger(ConverterController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Este metodo nos permitira intercambiar los simbolos de las mendas para que la conversion se reversible
     *
     * @param event
     */
    public void swapCurrency(ActionEvent event) {
        String monedaDes = monedaDestino_comboBox.getValue();
        String monedaOr = monedaOrigen_comboBox.getValue();
        monedaOrigen_comboBox.setValue(monedaDes);
        monedaDestino_comboBox.setValue(monedaOr);
    }

    /**
     * Este metodo nos permitira ejecutar la coonversion
     */
    public void exchangeCurrency(ActionEvent event) throws IOException {
        try {
            String from = monedaOrigen_comboBox.getSelectionModel().getSelectedItem().toString().substring(0,3);
            String to = monedaDestino_comboBox.getSelectionModel().getSelectedItem().toString().substring(0,3);
            Double amount = Double.parseDouble(inputMoneda_txtfield.getText());
            Double result = currencyService.convert(from, to, amount);
            outputMoneda_txtfield.setText(result + " " + to);

        } catch (Exception e) {
            alertMessage();
            System.err.println(e.getMessage());
        }
    }

    private void alertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dato inválido");
        alert.setContentText("Por favor rellene todos los campos");
        alert.showAndWait();
    }
    class Pair {
        String value1;
        String value2;

        public Pair(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    private void listSymbolNsignification(List<Currency> listCurrency,ComboBox<String> moneda) {
        List<String> listSymbols = currencyService.getAllSymbols(listCurrency);
        List<String> listSignification = currencyService.getSignification(listCurrency);
        
        List<Pair> combinedList = new ArrayList<>();
        for (int i = 0; i < listSymbols.size(); i++) {
            combinedList.add(new Pair(listSymbols.get(i), listSignification.get(i)));
        }

        Collections.sort(combinedList, Comparator.comparing(pair -> pair.value1));

        List<String> sortedlistSymbols = new ArrayList<>();
        List<String> sortedlistSignification = new ArrayList<>();
        for (Pair pair : combinedList) {
            sortedlistSymbols.add(pair.value1);
            sortedlistSignification.add(pair.value2);
        }
        for (int i = 0; i < sortedlistSymbols.size(); i++) {
            String listaOr = sortedlistSymbols.get(i) + " - " + sortedlistSignification.get(i);
            moneda.getItems().add(listaOr);
        }
    }
}