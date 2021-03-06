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
public class Test_ProducerSide {

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8080); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)


    @State("The value of 1 USD in INR is 65 INR")
    public void toGetState() {

    }

}
