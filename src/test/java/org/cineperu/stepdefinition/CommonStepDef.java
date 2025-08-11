package org.cineperu.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.cineperu.util.BaseUrl;
import org.cineperu.util.TokenManager;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.cineperu.question.CommonQuestion.*;
import static org.hamcrest.Matchers.equalTo;

public class CommonStepDef {
    @Steps
    BaseUrl base;

    @Given("^que (.*) llama al API$")
    public void queUSUARIOLlamaAlAPI(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(base.getBaseUrl()));
    }

    @Then("^valido el codigo de respuesta sea (.*)$")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        theActorInTheSpotlight().should(seeThat("El Codigo de Respúesta", httpStatusCode(), equalTo(statusCode)));
    }

    @And("^valido mensaje de error sea (.*)$")
    public void validoMensajeEroor(String error) {
        theActorInTheSpotlight().should(seeThat("Error", error(), equalTo(error)));
    }

    @And("^valido mensaje sea (.*)$")
    public void validoMensaje(String mensaje) {
        theActorInTheSpotlight().should(seeThat("Mensaje", mensaje(), equalTo(mensaje)));
    }

    @Given("^que (.*) inicia sesión$")
    public void queADMINIniciaSesión(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(base.getBaseUrl()));
        TokenManager.authenticate(
                base.getBaseUrl(),
                "admin@cineperu.com",
                "admin123");
    }
}
