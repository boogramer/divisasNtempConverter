package com.converter.currencyntempconverter.currencyconverter.services;

import com.converter.currencyntempconverter.currencyconverter.models.Currency;
import com.converter.currencyntempconverter.currencyconverter.respositories.Converter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class CurrencyService {
    private final Converter converter;

    public CurrencyService(Converter converter) {
        this.converter = converter;
    }

    public Double convert(String from, String to, Double amount) throws IOException {
        return converter.convert(from, to, amount);
    }

    public List<Currency> getAllCurrencies() throws IOException {
        return converter.getAllCurrencies();
    }

    public List<Currency> findCurrency(List<Currency> list, String symbol) {
        String symbol2 = toUpperCase(symbol);
        return list.stream().filter(currency -> currency.getSymbol()
                        .contains(symbol2))
                .collect(Collectors.toList());
    }

    public List<String> getAllSymbols(List<Currency> list) {
        return converter.getAllSymbols(list);
    }
    public List<String> getSignification(List<Currency> list) {
        return converter.getSignification(list);
    }

    private String toUpperCase(String str) {
        String st = "";
        for (int i = 0; i < str.length(); i++) {
            st += Character.toUpperCase(str.charAt(i)) + "";
        }
        return st;
    }
}
