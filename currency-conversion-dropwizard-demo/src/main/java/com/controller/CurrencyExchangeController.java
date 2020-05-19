package com.controller;

import com.beans.ExchangeValue;
import com.beans.ExchangeValueV2;
import com.db.CurrencyDB;
import com.db.CurrencyDBV2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/currency-exchange")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyExchangeController {

    /**
     * @author Kingshuk Nandy
     * @description Currency Exchange Method
     * @param from
     * @param to
     * @return
     */
    @GET
    @Path("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathParam("from") String from, @PathParam("to") String to) {

        ExchangeValue exchangeValue= CurrencyDB.getTheDesiredConversion(from,to);
        if (exchangeValue == null) {
            throw new RuntimeException("Unable to find data to convert " + from + " to " + to);
        }
        exchangeValue.setExchangeEnvironmentInfo(" ENV 1");

        return exchangeValue;
    }

    /**
     * @author Kingshuk Nandy
     * @description Modified Method, So as to fail the Producer Side Test
     * @param from
     * @param to
     * @return
     */
    /*@GET
    @Path("/from/{from}/to/{to}")
    public ExchangeValueV2 retrieveExchangeValue(@PathParam("from") String from, @PathParam("to") String to) {

        ExchangeValueV2 exchangeValue= CurrencyDBV2.getTheDesiredConversionV2(from,to);
        if (exchangeValue == null) {
            throw new RuntimeException("Unable to find data to convert " + from + " to " + to);
        }
       // exchangeValue.setExchangeEnvironmentInfo(" ENV 1");

        return exchangeValue;
    }*/
}
