package com.converter.divisasntempconverter.respositories;

import com.converter.divisasntempconverter.conectionAPI.JsonConversion;
import com.converter.divisasntempconverter.conectionAPI.ConectionToAPI;
import com.converter.divisasntempconverter.models.Currency;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ConverterImp implements Converter {
    private ConectionToAPI contectiontoApi;
    private JsonConversion jsonConversion;

    /**
     * contructor definido por las anteriores variables convocadas
     *
     * @param contectiontoApi para traer los metodos de su clase
     * @param jsonConversion  para traer los metodos de su clase
     */
    public ConverterImp(ConectionToAPI contectiontoApi, JsonConversion jsonConversion) {
        this.contectiontoApi = contectiontoApi;
        this.jsonConversion = jsonConversion;
    }

    /**
     * Este metodo convertira la moneda y retornara un valor de tipo Double
     * Usara los metodos 'getRate' para conectarse ala API y obtener la respuesta en JSON, luego se usara
     * el metodo 'getDataConversion' para hacer la conversion de JSON a Double
     *
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
     * @param list
     * @return
     */
    @Override
    public List<String> getAllSymbols(List<Currency> list) {
        return null;
    }

}
