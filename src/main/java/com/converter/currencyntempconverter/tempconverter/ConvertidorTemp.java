package com.converter.currencyntempconverter.tempconverter;

public abstract class ConvertidorTemp {
    private String newValue;
    protected double temp1;
    protected double temp2;
    protected double temp3;

    public String setNewValue(String newValue) {
        this.newValue = newValue;
        return newValue;
    }

}
