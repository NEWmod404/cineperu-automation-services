package org.cineperu.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.cineperu.util.ApiCommon;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRecuperarContrasenia implements Task {

    private static String URL_PATH = "/auth/recuperar";
    private static String JSON_PATH = "request/postRecuperarContrasenia.json";

    private final String correo, contrasenia1, contrasenia2;

    public PostRecuperarContrasenia(String correo, String contrasenia1, String contrasenia2) {
        this.correo = correo;
        this.contrasenia1 = contrasenia1;
        this.contrasenia2 = contrasenia2;
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
                                    .replace("{correo}", correo)
                                    .replace("{contrasenia1}", contrasenia1)
                                    .replace("{contrasenia2}", contrasenia2)
                            )));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
    }

    public static Performable sending(String correo, String contrasenia1, String contrasenia2) {
        return instrumented(PostRecuperarContrasenia.class, correo, contrasenia1, contrasenia2);
    }
}
