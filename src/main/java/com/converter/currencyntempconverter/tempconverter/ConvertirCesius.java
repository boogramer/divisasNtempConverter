package com.converter.currencyntempconverter.tempconverter;

public class ConvertirCesius extends ConvertidorTemp implements MetodosConvertirTemp {

    @Override
    public double convertirTemeperaturaCaso1(String newvalue) {
        // convertir a rankine
        temp1 = Double.parseDouble(super.setNewValue(newvalue)) * 1.8 + 491.67;
        return temp1;
    }

    @Override
    public double convertirTemeperaturaCaso2(String newvalue) {
        // Convertir a Kelvin
        temp2 = Double.parseDouble((super.setNewValue(newvalue))) + 273.15;
        return temp2;
    }

    @Override
    public double convertirTemeperaturaCaso3(String newvalue) {
        // Convertir a Fahrenheit
        temp3 = Double.parseDouble(super.setNewValue(newvalue)) * 1.8 + 32;
        return temp3;
    }
}
