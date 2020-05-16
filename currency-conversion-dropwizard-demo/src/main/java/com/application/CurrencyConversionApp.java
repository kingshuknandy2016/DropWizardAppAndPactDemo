package com.application;

import com.controller.CurrencyExchangeController;
import com.configuration.EnvironmentConfiguration;
import com.controller.resources.EnvHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyConversionApp extends Application<EnvironmentConfiguration> {

    private static final Logger LOGGER= LoggerFactory.getLogger(CurrencyConversionApp.class);

    public void run(EnvironmentConfiguration environmentConfiguration, Environment environment) throws Exception {
        final CurrencyExchangeController currencyExchangeController=new CurrencyExchangeController();

        final EnvHealthCheck envHealthCheck=new EnvHealthCheck(environmentConfiguration.getEnvName());
        environment.healthChecks().register("EnvCheck",envHealthCheck);

        environment.jersey().register(new CurrencyExchangeController());
    }

    public static void main(String[] args) {
        try {
            new CurrencyConversionApp().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
