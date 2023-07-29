package com.converter.divisasntempconverter.conectionAPI;
import org.json.JSONObject;
public class JsonConversion {
    public Double getDataConversion(StringBuilder stringBuilder){
        JSONObject myResponse=new JSONObject(stringBuilder.toString());
        return myResponse.getDouble("result");
    }
    public String[]getDataSymbols(StringBuilder stringBuilder){
        JSONObject myResponse=new JSONObject(stringBuilder.toString());
        String symbolsCurrencies[]=myResponse.get("symbols").toString().split(",");
        return symbolsCurrencies;
    }
    public String[]getDataHistoricalCurrency(StringBuilder stringBuilder){
        JSONObject myResponse=new JSONObject(stringBuilder.toString());
        String historicalValues[]=myResponse.get("rates").toString().split(",");
        return  historicalValues;}
}
