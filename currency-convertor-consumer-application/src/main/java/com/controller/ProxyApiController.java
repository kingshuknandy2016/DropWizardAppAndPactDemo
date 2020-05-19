package com.controller;

import com.beans.ExchangeValue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ProxyApiController {

    public static String getApplicationUrl(String protocol,String host,int port){
        return protocol+"://"+host+":"+port;
    }

    public static Response retrieveResponse(String targetUrl){
        Client client= ClientBuilder.newClient();
        WebTarget webTarget=client.target(targetUrl);
        Response response=webTarget
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response;
    }

    public static ExchangeValue retrieveExchangeValue(String url,String from,String to){

        ExchangeValue exchangeValue=retrieveResponse(url + "/currency-exchange/from/"+from+"/to/"+to).readEntity(ExchangeValue.class);
        return exchangeValue;
    }
}
