package com.controller;

import com.beans.ExchangeValue;
import com.db.CurrencyDB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/currency-exchange")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyExchangeController {

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
}
