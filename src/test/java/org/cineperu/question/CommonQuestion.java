package org.cineperu.question;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class CommonQuestion {
    public static Question<Integer> httpStatusCode() {
        return Question.about("El Codigo de Respuesta")
                .answeredBy(actor -> SerenityRest.lastResponse().getStatusCode());
    }

    public static Question<String> error() {
        return Question.about("Error")
                .answeredBy(actor -> SerenityRest.lastResponse().getBody().jsonPath().getString("error"));
    }

    public static Question<String> mensaje() {
        return Question.about("mensaje")
                .answeredBy(actor -> SerenityRest.lastResponse().getBody().jsonPath().getString("mensaje"));
    }
}
