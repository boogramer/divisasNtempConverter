package com.converter.divisasntempconverter.respositories;

import com.converter.divisasntempconverter.conectionAPI.JsonConversion;
import com.converter.divisasntempconverter.conectionAPI.ConectionToAPI;
import com.converter.divisasntempconverter.models.Currency;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class ConverterImp implements Converter {
    private ConectionToAPI contectiontoApi;
    private JsonConversion jsonConversion;

    /**
     * contructor definido por las anteriores variables convocadas
     */
    public ConverterImp(ConectionToAPI contectiontoApi, JsonConversion jsonConversion) {
        this.contectiontoApi = contectiontoApi;
        this.jsonConversion = jsonConversion;
    }

    /**
     * Este metodo convertira la moneda y retornara un valor de tipo Double
     * Usara los metodos 'getRate' para conectarse ala API y obtener la respuesta en JSON, luego se usara
     * el metodo 'getDataConversion' para hacer la conversion de JSON a Double
     * @param from  simbolo moneda origen
     * @param to    simbolo moneda destino
     * @param value valor que se desea convertir
     * @return valor de la moneda convetida aen Double
     * @throws MalformedURLException
     * @throws IOException
     */
    @Override
    public Double convert(String from, String to, Double value)
            throws MalformedURLException, IOException {
        StringBuilder sb = contectiontoApi.getRate(from, to, value);
        Double result = jsonConversion.getDataConversion(sb);
        return result;
    }

    /**
     * @return Lista de todos los simbolos de las monedas con sus siginificado
     * @throws MalformedURLException
     * @throws IOException
     */
    @Override
    public List<Currency> getAllCurrencies() throws MalformedURLException, IOException {
        List<Currency> listCurrencies = new ArrayList();
        StringBuilder sb = contectiontoApi.getSymbolsWithSignification();
        String SymbolsSignification[] = jsonConversion.getDataSymbols(sb);
        for (String line : SymbolsSignification) {
            String tmp[] = line.split(":");
            String symbol = tmp[0].replace("{", "").replace("\"", "");
            String signification = tmp[1].replace("}", "").replace("\"", "");
            Currency currency = new Currency(symbol, signification);
            listCurrencies.add(currency);
        }
        return listCurrencies;
    }

    /**
     * Este metodo extrae todos los simbolos de las monedas y los retorna de manera alfabeticamente
     * @param list lista de todos los objetos
     * @return
     */
    @Override
    public List<String> getAllSymbols(List<Currency> list) {
            List<String> listSymbols = list.stream().map(currency -> currency.getSymbol())
                .collect(Collectors.toList());
        return listSymbols;
    }

    @Override
    public List<String> getSignification(List<Currency> list) {
        List<String> listSignification = list.stream().map(currency -> currency.getSignification())
                .collect(Collectors.toList());
        return listSignification;
    }
}
