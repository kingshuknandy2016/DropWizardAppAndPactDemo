# DropWizard Framework And PACT Demo

## Overview
We have developed an Microservice Application Using [ Dropwizard Framework ](https://www.dropwizard.io/en/latest/index.html).
Then we have included the Unit Tests related to the Application.
It also have Consumer driven test by using [Pact](https://docs.pact.io/).

## Contents
* Microservice 1- Application : [currency-conversion-dropwizard-demo](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/currency-conversion-dropwizard-demo).

* The [Consumer Side Test Project](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/consumer-side-test)

* The [Producer Side Test Project](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/producer-side-test)

* The [Pact folder](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/pacts) which contains the pact files generate by the [Consumer Side Test Project](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/consumer-side-test)

* The [Docker Compose file](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/dockerpactbroker) to start the Pact Broker


## Micoservice Details


### Microservice Service 1: Currency Exchange Service

If you ask it the value of 1 USD in INR, or 1 Australian Dollar in INR, the Currency Exchange Service answers 
- 1 USD is 60 INR
- 1 Australian Dollars is 50 INR. 

http://localhost:8080/currency-exchange/from/EUR/to/INR

```json
{
  "id": 10002,
  "from": "EUR",
  "to": "INR",
  "conversionMultiple": 75.00,
  "exchangeEnvironmentInfo": "37f1ad927c6e v1 27c6e"
}
```

## Execution

### Step 1: The Application Deployment

* Build Application Jar File : <br/> 
***mvn clean package***<br/>
This will first perform **mvn clean test** on the [currency-conversion-dropwizard-demo](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/currency-conversion-dropwizard-demo)application which will run all **unit test**<br/>
And then create a *DropWizardDemo-1.0-SNAPSHOT.jar* inside the target folder

* Start application in jetty server(Default DropWizard Server) :<br/> 
***java -jar target/DropWizardDemo-1.0-SNAPSHOT.jar server example.yml***<br/>

Now, the application is up and running and it will be accessable in the port.<br/>
http://localhost:8080/currency-exchange/from/EUR/to/INR

### Step 2: Run the Consumer Side Test 

and **consumer driven test**.
As a part of running the **consumer driven test** the pact files will be generated inside the *target/mypacts* folder


