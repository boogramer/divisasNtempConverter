package com.converter.currencyntempconverter.tempconverter;

public class ConvertirFahrenheit extends ConvertidorTemp  implements MetodosConvertirTemp {

    @Override
    public double convertirTemeperaturaCaso1(String newvalue) {
        // convertir a celsius
        temp1 = (Double.parseDouble((super.setNewValue(newvalue)))-32) /1.8;
        return temp1;
    }

    @Override
    public double convertirTemeperaturaCaso2(String newvalue) {
        // Convertir a rankine
       temp2 = Double.parseDouble(super.setNewValue(newvalue)) + 459.67;
       return temp2;
    }

    @Override
    public double convertirTemeperaturaCaso3(String newvalue) {
        // Convertir a kelvin
        temp3 = (Double.parseDouble(super.setNewValue(newvalue)) + 459.67) * 5 / 9;
        return temp3;
    }
}
