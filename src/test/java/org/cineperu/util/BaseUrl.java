package org.cineperu.util;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class BaseUrl {
    private EnvironmentVariables environmentVariables;

    public String getBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("cineperu.base.url");
    }
}
