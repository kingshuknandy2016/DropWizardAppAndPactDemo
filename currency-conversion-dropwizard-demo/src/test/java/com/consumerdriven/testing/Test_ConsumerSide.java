package com.consumerdriven.testing;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;


public class Test_ConsumerSide {

    public int mockPort=8111;

    /**
     * @author Kingshuk Nandy
     * @description This will generate a mock provider service
     */
    @Rule
    public PactProviderRuleMk2 currencyExchange_mockProvider=
            new PactProviderRuleMk2("currencyExchange_provider","localhost",mockPort,this);


    /**
     * @author Kingshuk Nandy
     * @description This will create a pact file
     */
    @Pact(consumer = "currencyExchange_Consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        HashMap<String,String> headers=new HashMap<>();
        headers.put("Content-Type", "application/json");
        //From the consumer side we tell that we need the following things in the response
        DslPart currencyConversionRespBody = new PactDslJsonBody()
                .integerType("id",10001)
                .stringType("from", "USD")
                .stringType("to", "INR")
                .integerType("conversionMultiple",65)
                .stringType("exchangeEnvironmentInfo"," ENV 1")
                .asBody();

        return builder.given("The value of 1 USD in INR is 65 INR")
                .uponReceiving("GET REQUEST /currency-exchange/from/{from}/to/{to}")
                .path("/currency-exchange/from/USD/to/INR")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(currencyConversionRespBody)
                .toPact();  // This creates a pact file
    }

    /**
     * @author kingshuk.n
     * @description This is the Consumer side Tests
     */
    @Test
    @PactVerification
    public void givenGet_currencyExchange_shouldReturn200_with_properBody(){

        Client client= ClientBuilder.newClient();
        WebTarget webTarget=client.target(currencyExchange_mockProvider.getUrl() + "/currency-exchange/from/USD/to/INR");
        Response response=webTarget
                .request(MediaType.APPLICATION_JSON)
                .get();
        Assert.assertEquals(response.getStatus(),200);

    }

}
