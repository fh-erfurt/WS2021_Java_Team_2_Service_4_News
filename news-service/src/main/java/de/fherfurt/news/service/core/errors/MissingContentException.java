package de.fherfurt.news.service.core.errors;

import de.fherfurt.news.service.core.persistence.errors.PersistenceException;

import lombok.NoArgsConstructor;

/**
 * Thrown if the content (byte array of a file) is missing but required.
 *
 * @author Michael Rhoese <michael.rhoese@fh-erfurt.de>
 */
@NoArgsConstructor
public class MissingContentException extends PersistenceException {
    public MissingContentException(String message) {
        super(message);
    }
}