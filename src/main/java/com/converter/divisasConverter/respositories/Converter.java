package com.converter.divisasConverter.respositories;

import com.converter.divisasConverter.models.Currency;

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
