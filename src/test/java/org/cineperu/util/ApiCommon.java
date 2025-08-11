package org.cineperu.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class ApiCommon {
    public static String getTemplate(String templatePath) {
        try {
            return IOUtils.toString(new ClassPathResource(templatePath).getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final int STATUS_CODE_OK = 200;
    public static final int STATUS_CODE_CREATED = 201;
    public static final int STATUS_CODE_NO_CONTENT = 204;
    public static final int STATUS_CODE_BAD_REQUEST = 400;
    public static final int STATUS_CODE_UNAUTHORIZED = 401;
    public static final int STATUS_CODE_FORBIDDEN = 403;
    public static final int STATUS_CODE_NOT_FOUND = 404;

    private ApiCommon() {
    }
}
