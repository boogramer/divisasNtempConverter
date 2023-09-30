package com.converter.currencyntempconverter.tempconverter;

import javafx.scene.control.TextField;

public class ConvertTemp {
    public void converterToKelvin(TextField temp, TextField tempKelvin) {
        tempKelvin.textProperty().bind(temp.textProperty());
    }
}
