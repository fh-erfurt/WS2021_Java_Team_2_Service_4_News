package de.fherfurt.news.service.core.persistence.errors;

import de.fherfurt.news.service.core.persistence.Id;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * Thrown if an entity has multiple fields that are annotated with{@link Id}.
 *
 * @author Michael Rhoese <michael.rhoese@fh-erfurt.de>
 */
@RequiredArgsConstructor
public class TooManyPrimaryKeysException extends RuntimeException {
    private final String type;

    private TooManyPrimaryKeysException(String message, String type) {
        super(message);
        this.type = type;
    }

    public static TooManyPrimaryKeysException of(Class<?> clazz) {
        return of(clazz, null);
    }

    public static TooManyPrimaryKeysException of(Class<?> clazz, String message) {
        return new TooManyPrimaryKeysException(message, clazz.getSimpleName());
    }

    @Override
    public String getLocalizedMessage() {
        return "More then one primary key found on type '" + type + "'." + (Objects.isNull(getMessage()) ? "" : " " + getMessage());
    }
}
