package com.converter.currencyntempconverter.currencyconverter.conectionAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * clase con metodos necesarios para hacer la conexion con la API
 * para este conversor se utilizara Ficer API de APILayer
 */
public class ConectionToAPI {
    private final String url;
    private final String apiKey;

    public ConectionToAPI(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

    /**
     * Se usara este metodo para enviar los parametros al 'REST' services para la conversion de la moneda
     *
     * @param monOrigen  moneda oringen que se ingresara en la app
     * @param monDestino moneda destino que se ingresara en la app
     * @param monto      monto a convertir
     * @return respuesta de la moneda en JSON
     * @throws MalformedURLException se lanza la excepcion cuando se obtiene una URL mal formada
     * @throws IOException           excepción comprobada que se lanza cuando ocurre un error de entrada/salida durante la ejecución de la app.
     */
    public StringBuilder getRate(String monOrigen, String monDestino, Double monto)
            throws MalformedURLException, IOException {
        URL objUrl = new URL(url + "/convert?to=" + monDestino + "&from=" + monOrigen + "&amount=" + monto);
        HttpURLConnection http = (HttpURLConnection) objUrl.openConnection();
        http.setRequestProperty("apikey", apiKey);
        StringBuilder sb = getStringbuilder(http);
        return sb;
    }

    /**
     * Metodo usado para concectarse con la API y obtener informacion de los simbolos de las monedas y lo que significa cada una
     * @return respuesta de la solicitud
     * @throws MalformedURLException se lanza la excepcion cuando se obtiene una URL mal formada
     * @throws IOException           excepción comprobada que se lanza cuando ocurre un error de entrada/salida durante la ejecución de la app.
     */
    public StringBuilder getSymbolsWithSignification() throws MalformedURLException
            , IOException {
        URL objUrl = new URL(url + "/symbols");
        HttpURLConnection http = (HttpURLConnection) objUrl.openConnection();
        http.setRequestProperty("apikey", apiKey);
        StringBuilder sb = getStringbuilder(http);
        return sb;
    }

    /**
     * Metodo corrobora si la conexion es correcta con el codigo de respuesta con 'getResponseCode()'
     * para luego leer cada respuesta del servidor  con 'while'
     * @param http
     * @return datos de la respuesta de la API
     * @throws IOException error durante la ejecucion
     */
    private StringBuilder getStringbuilder(HttpURLConnection http) throws IOException {
        if (http.getResponseCode() != 200) // codigo 200 indica que la conexion se hizo de manera correcta
            throw new IllegalStateException("La conexion no ha sido exitosa" + http.getResponseCode());
        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream())); //para leer la respuesta de la solicitud
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        return sb;
    }
}
