package org.cineperu.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        glue = {"org.cineperu.stepdefinition"},
        features = "src/test/resources/feature",
        tags = "@SIGNUP and @UNHAPPYPATH"
)
public class CucumberTestSuite {
    private static final EnvironmentVariables envs = SystemEnvironmentVariables.createEnvironmentVariables();
    @BeforeClass
    public static void beforeAll() {
        Logger.getLogger(CucumberTestSuite.class.getName()).info("Before all execution >>>");
    }
}