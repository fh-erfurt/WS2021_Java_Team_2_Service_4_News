package de.fherfurt.news.service.core.persistence.errors;

import lombok.NoArgsConstructor;

/**
 * Thrown if a database request returns more than one result.
 *
 * @author Michael Rhoese <michael.rhoese@fh-erfurt.de>
 */
@NoArgsConstructor
public class TooManyResultsException extends PersistenceException {
    public TooManyResultsException(String message) {
        super(message);
    }
}
