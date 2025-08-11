package org.cineperu.util;

import net.serenitybdd.rest.SerenityRest;

import static io.restassured.http.ContentType.JSON;

public class TokenManager {
    private static String token;
    public static void authenticate(String baseUrl, String correo, String contrasenia) {
        String body = """
            {
              "correo": "%s",
              "contraseña": "%s"
            }
        """.formatted(correo, contrasenia);

        token = SerenityRest
                .given()
                .baseUri(baseUrl)
                .contentType(JSON)
                .body(body)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    public static String getToken() {
        if (token == null) {
            throw new IllegalStateException("Token no inicializado. Ejecuta authenticate() primero.");
        }
        return token;
    }
}
