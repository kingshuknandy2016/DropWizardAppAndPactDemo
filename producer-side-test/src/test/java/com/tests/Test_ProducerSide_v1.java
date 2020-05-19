package com.tests;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)  // Say JUnit to run tests with custom Runner
@Provider("currencyExchange_provider")     // Set up name of tested provider
@PactFolder("../pacts")     // Point where to find pacts (See also section Pacts source in documentation)
public class Test_ProducerSide_v1 {

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8080); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)


    @State("Producer Test for 1 USD to 1 INR conversion")
    public void verifySingleUSDtoINRinteraction() {

    }

    @State("The output of currency exchange service from 1 USD to 1 INR")
    public void verifyMultipleUSDtoINRinteraction() {

    }

    @State("The output of currency exchange service from 1 EUR to 1 INR")
    public void verifyMultipleEURtoINRinteraction() {

    }

    @State("The output of currency exchange service from 1 AUD to 1 INR")
    public void verifyMultipleAUDtoINRinteraction() {

    }

}
