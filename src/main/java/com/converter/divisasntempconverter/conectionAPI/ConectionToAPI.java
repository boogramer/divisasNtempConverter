package com.converter.divisasntempconverter.conectionAPI;

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

    // contructor
    public ConectionToAPI(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }
    // se usara StringBuilder para modificar la cadena de texto

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
        URL objUrl = new URL(url + "/convert?to=" + monOrigen + "&from=" + monDestino + "&amount=" + monto);
        HttpURLConnection http = (HttpURLConnection) objUrl.openConnection();
        http.setRequestProperty("apikey", apiKey);
        StringBuilder sb = getStringbuilder(http);
        return sb;
    }

    /**
     * Metodo usado para concectarse con la API y obtener informacion de los simbolos de las monedas y lo que significa
     * cada uno
     * @return respuesta de la API
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


/*    public StringBuilder getHistoricalCurrency(String base,LocalDate stratDate
            ,LocalDate endDate,String symbol) throws MalformedURLException, IOException{
        URL objUrl=new URL(url+"/timeseries?start_date="+stratDate+"&end_date="
                +endDate+"&base="+base+"&symbols="+symbol);
        HttpURLConnection http=(HttpURLConnection) objUrl.openConnection();
        http.setRequestProperty("apikey", apiKey);
        StringBuilder sb=getStringbuilder(http);
        return sb;
        }*/

    /**
     * Metodo corrobora si la conexion es correcta con el codigo de respuesta con 'getResponseCode()'
     * para luego leer cada respuesta del servidor  con 'while'
     * @param http
     * @return datos de la respuesta de la API
     * @throws IOException error durante la ejecucion
     */
    private StringBuilder getStringbuilder(HttpURLConnection http) throws IOException {
        if (http.getResponseCode() != 200) // codigo 200 indica que la conexion se hizo de manera correcta
            throw new IllegalStateException("La conexion no se ha sido exitosa" + http.getResponseCode());
        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        return sb;
    }
}