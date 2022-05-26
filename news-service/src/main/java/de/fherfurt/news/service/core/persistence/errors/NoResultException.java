package de.fherfurt.news.service.core.persistence.errors;

import lombok.NoArgsConstructor;

/**
 * Thrown if a result of a database request is expected but there wasn't any.
 *
 */
@NoArgsConstructor
public class NoResultException extends PersistenceException {
    public NoResultException(String message) {
        super(message);
    }
}
