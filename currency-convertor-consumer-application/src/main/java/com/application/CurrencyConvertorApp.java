package com.application;

import com.configuration.EnvironmentConfiguration;
import com.controller.CurrencyConvertorController;
import com.controller.resources.EnvHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyConvertorApp extends Application<EnvironmentConfiguration> {

    private static final Logger LOGGER= LoggerFactory.getLogger(CurrencyConvertorApp.class);
    @Override
    public void run(EnvironmentConfiguration environmentConfiguration, Environment environment) throws Exception {
        final CurrencyConvertorController currencyConvertorController=new CurrencyConvertorController();

        EnvHealthCheck envHealthCheck=new EnvHealthCheck(environmentConfiguration.getEnvName());
        environment.healthChecks().register("envCheck-Application2",envHealthCheck);

        environment.jersey().register(currencyConvertorController);
    }

    public static void main(String[] args) {
        try {
            new CurrencyConvertorApp().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
