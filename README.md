# DropWizard Framework And PACT Demo

## Overview
We have developed an Microservice Application Using [ Dropwizard Framework ](https://www.dropwizard.io/en/latest/index.html).
Then we have included the Unit Tests related to the Application.
It also have Consumer driven test by using [Pact](https://docs.pact.io/).

## Contents
* Microservice 1- Application : [currency-conversion-dropwizard-demo](https://github.com/kingshuknandy2016/DropWizardAppAndPactDemo/tree/master/currency-conversion-dropwizard-demo) which also includes the consumer driven test inside the test  folder


## Micoservice Details


### Microservice Service 1: Currency Exchange Service

If you ask it the value of 1 USD in INR, or 1 Australian Dollar in INR, the Currency Exchange Service answers 
- 1 USD is 60 INR
- 1 Australian Dollars is 50 INR. 

http://localhost:8000/currency-exchange/from/EUR/to/INR

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

Step 1: Build Application Jar File :
-- mvn clean package
This will first perform **mvn clean test** on the application which will run all **unit test** and **consumer driven test**.
As a part of running the **consumer driven test** the pact files will be generated inside the *target/mypacts* folder
