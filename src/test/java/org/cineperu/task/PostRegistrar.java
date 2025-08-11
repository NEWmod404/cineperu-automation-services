package org.cineperu.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.cineperu.util.ApiCommon;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRegistrar implements Task {

    private static String URL_PATH = "/usuarios/registrar";
    private static String JSON_PATH = "request/postRegistrar.json";

    private final String nombre, apellido, correo, contrasenia;

    public PostRegistrar(String nombre, String apellido, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Post.to(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("Content-Type", "application/json")
                            .log().all()
                            .body(ApiCommon.getTemplate(JSON_PATH)
                                    .replace("{nombre}", nombre)
                                    .replace("{apellido}", apellido)
                                    .replace("{correo}", correo)
                                    .replace("{contrasenia}", contrasenia)
                            )));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
    }

    public static Performable sending(String nombre, String apellido, String correo, String contrasenia) {
        return instrumented(PostRegistrar.class, nombre, apellido, correo, contrasenia);
    }
}
