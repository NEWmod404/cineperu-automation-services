package org.cineperu.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.cineperu.task.PostRegistrar;
import org.cineperu.util.DataGenerator;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostRegistroStepDef {
    Faker faker = new Faker();
    private String nombre, apellido, correo, contrasenia;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

     @And("^obtengo datos dinamicos para nombre, apellido, correo con contraseña (.*)$")
    public void obtengoDatosDinamicosConContraseña(String contrasenia) {
        this.nombre = faker.name().firstName();
        this.apellido = faker.name().lastName();
        this.correo = DataGenerator.randomEmail();
        this.contrasenia = contrasenia;
    }

    @When("^ejecuta el API registrar con los datos dinamico$")
    public void ejecutaElAPIRegistrar() {
        theActorInTheSpotlight().attemptsTo(PostRegistrar.sending(nombre, apellido, correo, contrasenia));
    }

    @When("^ejecuta el API registrar con (.*),(.*), (.*), (.*)$")
    public void ejecutaElAPIRegistrarConNombreApellidoCorreoContrasenia(String nombre, String apellido, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        theActorInTheSpotlight().attemptsTo(PostRegistrar.sending(nombre, apellido, correo, contrasenia));
    }
}
