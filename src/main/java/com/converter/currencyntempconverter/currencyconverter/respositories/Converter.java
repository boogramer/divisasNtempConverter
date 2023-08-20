package com.converter.currencyntempconverter.currencyconverter.respositories;

import com.converter.currencyntempconverter.currencyconverter.models.Currency;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
public interface Converter {
    Double convert(String from, String to, Double value)
            throws MalformedURLException, IOException;

    List<Currency> getAllCurrencies() throws MalformedURLException, IOException;

    List<String> getAllSymbols(List<Currency> list);

    List<String> getSignification(List<Currency> list);
}
