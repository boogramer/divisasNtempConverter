package com.converter.divisasntempconverter.services;

import com.converter.divisasntempconverter.models.HistoricalCurrency;
import com.converter.divisasntempconverter.respositories.Converter;

import java.io.IOException;
import java.util.List;

public class HistoricalCurrencyService {
    private final Converter converter;

    public HistoricalCurrencyService(Converter converter) {
        this.converter = converter;
    }
    public List<HistoricalCurrency> HistoricalDataCurrency(String base
            , Integer durationDay, String symbol) throws IOException {
        return converter.getHistoricalVlues(base, durationDay, symbol);
    }
}
