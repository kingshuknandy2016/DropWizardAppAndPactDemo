package com.controller.resources;

import com.codahale.metrics.health.HealthCheck;

public class EnvHealthCheck extends HealthCheck {

    private final String environment;

    public EnvHealthCheck(String environment) {
        this.environment=environment;
    }

    protected Result check() throws Exception {
        if ( environment.equalsIgnoreCase("STAGE"))
            return Result.healthy();
        else
            return Result.unhealthy("The STAGE is not Properly Up");
    }
}
