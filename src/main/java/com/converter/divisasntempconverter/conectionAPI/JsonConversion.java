package com.converter.divisasntempconverter.conectionAPI;

import org.json.JSONObject;

/**
 * Esta clase toma los datos repuesta tipo String  para hacer la conversion a los datos  a JSON a los que se requiera ej: String, Doueble. OJO
 */
public class JsonConversion {
    /**
     * Lo que realiza este metodo es tomar la repuesta de la API en formato JSON y la convierte en Double, tomando
     * como clave 'result' en el JS0N para despues devolverlo como Double
     * @param stringBuilder parametro que contiene la respuesta en JSON
     * @return valor de la moneda convertida en Double
     */
    public Double getDataConversion(StringBuilder stringBuilder) {
        JSONObject myResponse = new JSONObject(stringBuilder.toString());
        return myResponse.getDouble("result");
    }
    /**
     * Este metodo similar al otro pero  accdede a la respuesta con la clave 'symbols' en el JSON para despues retornar un array con varias cadenas separadas por ','
     * @param stringBuilder parametro que contiene la respuesta en JSON
     * @return devuelve el array de los simbolos de las monedas
     */
    public String[] getDataSymbols(StringBuilder stringBuilder) {
        JSONObject myResponse = new JSONObject(stringBuilder.toString());
        String symbolsCurrencies[] = myResponse.get("symbols").toString().split(",");
        return symbolsCurrencies;
    }
}
