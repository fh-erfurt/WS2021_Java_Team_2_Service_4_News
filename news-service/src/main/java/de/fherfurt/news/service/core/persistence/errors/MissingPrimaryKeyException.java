package de.fherfurt.news.service.core.persistence.errors;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * Thrown if an entity hasn't a field that is annotated with {@link Id}.
 *
 */
@RequiredArgsConstructor
public class MissingPrimaryKeyException extends RuntimeException {
    private final String type;

    private MissingPrimaryKeyException(String message, String type) {
        super(message);
        this.type = type;
    }

    public static MissingPrimaryKeyException of(Class<?> clazz) {
        return of(clazz, null);
    }

    public static MissingPrimaryKeyException of(Class<?> clazz, String message) {
        return new MissingPrimaryKeyException(message, clazz.getSimpleName());
    }

    @Override
    public String getLocalizedMessage() {
        return "Could not find a primary key on type '" + type + "'." + (Objects.isNull(getMessage()) ? "" : " " + getMessage());
    }
}
