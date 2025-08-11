package org.cineperu.util;

import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("es"));

    public static String randomEmail() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "user" + timestamp + "@cineperu.com";
    }

    public static String randomTitleMovie() {
        String parte1 = faker.book().title();
        String parte2 = faker.artist().name();
        String timestamp = new SimpleDateFormat("mmss").format(new Date());
        return parte1 + " " + parte2 + " " + timestamp;
    }

    public static String loremIpsum() {
        return faker.lorem().paragraph();
    }
}
