package com.converter.divisasntempconverter.respositories;

import com.converter.divisasntempconverter.models.Currency;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Interface usada para la conversion de las monedas
 *
 */
public interface Converter {
    Double convert(String from,String to,Double value)
            throws MalformedURLException, IOException;
    List<Currency> getAllCurrencies() throws MalformedURLException,IOException;
    List<String> getAllSymbols(List<Currency> list);
    // pedente de si se implementara un historial de todos lo valores de las monedas
    /*List<HistoricalCurrency> getHistoricalVlues(String base,Integer durationDays,String symbol)
            throws MalformedURLException,IOException;*/
}
