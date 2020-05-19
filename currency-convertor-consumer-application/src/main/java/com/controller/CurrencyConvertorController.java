package com.controller;

import com.beans.CurrencyConversionBean;
import com.beans.ExchangeValue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/currency-conversion")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyConvertorController {

    int port=8080;
    String protocol="http";
    String host="localhost";

    @GET
    @Path("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retrieveConversionValue(@PathParam("from") String from, @PathParam("to") String to,@PathParam("quantity") int quantity) {

        String url=ProxyApiController.getApplicationUrl(protocol,host,port);
        ExchangeValue exchangeValue=ProxyApiController.retrieveExchangeValue(url,from,to);
        int convertedValue=exchangeValue.getConversionMultiple()*quantity;
        String conversionEnvInfo="conversion-env-1";

        return new CurrencyConversionBean(exchangeValue.getId(),
                from,
                to,
                exchangeValue.getConversionMultiple(),
                quantity,
                convertedValue,
                exchangeValue.getExchangeEnvironmentInfo(),
                conversionEnvInfo);
    }
}
