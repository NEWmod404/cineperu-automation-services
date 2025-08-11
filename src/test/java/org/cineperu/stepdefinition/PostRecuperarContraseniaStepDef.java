package org.cineperu.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.cineperu.task.PostRecuperarContrasenia;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostRecuperarContraseniaStepDef {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^ejecuta el API recuperar contraseña con (.*), (.*), (.*)$")
    public void ejecutaElAPIRecuperarContraseña(String correo, String contrasenia1, String contrasenia2) {
        theActorInTheSpotlight().attemptsTo(PostRecuperarContrasenia.sending(correo, contrasenia1, contrasenia2));
    }
}
