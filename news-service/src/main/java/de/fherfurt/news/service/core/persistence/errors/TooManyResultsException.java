package de.fherfurt.news.service.core.persistence.errors;

import lombok.NoArgsConstructor;

/**
 * Thrown if a database request returns more than one result.
 *
 */
@NoArgsConstructor
public class TooManyResultsException extends PersistenceException {
    public TooManyResultsException(String message) {
        super(message);
    }
}
