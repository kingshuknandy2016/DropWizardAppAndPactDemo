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

### Step 2: Start a Pact Broker

* Run the [docker compose file](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/blob/master/dockerpactbroker/docker-compose.yml) <br/>
***docker-compose up***<br/>

The Broker will be up and running http://localhost:8113/

### Step 3: Run the Consumer Side Test

* Run the Consumer Side Test and Generate the Pact Files<br/>
We will navigate to the [consumer-side-test Project](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/consumer-side-test).<br/>
Then run the command, ***mvn clean test***<br/>
It will run all the Consumer side test, and also generate the [pact files](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/pacts)

* Push the Generate Pact Files into the Pact Broker<br/>
***mvn pact:publish***<br/>
You will be able to see the Contract Details from the Broker UI.

### Step 4: Verify the Contract from the Producer Side

* Run the Producer Test
We will navigate to the [producer-side-test Project](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/producer-side-test).<br/>
Then run the command, ***mvn pact:verify***<br/>
It will verify the Customer Contract in the Producer End by taking the contract from the Broker

You will be able to see the Verification Details from the Broker UI.


### Step 4: Break the API on the Provider Side and run the test again

