package org.cineperu.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.cineperu.util.ApiCommon;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostLogin implements Task {

    private static String URL_PATH = "/auth/login";
    private static String JSON_PATH = "request/postLogin.json";

    private final String correo, contrasenia;

    public PostLogin(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(Post.to(URL_PATH)
                    .with(request ->request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("Content-Type","application/json")
                            .log().all()
                            .body(ApiCommon.getTemplate(JSON_PATH)
                                    .replace("{correo}",correo)
                                    .replace("{contrasenia}",contrasenia)
                            )));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
    }

    public static Performable sending(String correo, String contrasenia) {
        return instrumented(PostLogin.class, correo, contrasenia);
    }
}
