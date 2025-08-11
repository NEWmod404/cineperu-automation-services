package org.cineperu.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.cineperu.task.PostLogin;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostLoginStepDef {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^ejecuta el API login con correo (.*), contraseña (.*)$")
    public void ejecutaElAPILogin(String correo, String contrasenia) {
        theActorInTheSpotlight().attemptsTo(PostLogin.sending(correo,contrasenia));
    }
}
