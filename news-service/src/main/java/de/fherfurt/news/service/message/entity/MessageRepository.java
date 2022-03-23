package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.Database;
import de.fherfurt.news.service.core.persistence.Repository;
import de.fherfurt.news.service.core.persistence.errors.NoResultException;
import de.fherfurt.news.service.core.persistence.errors.TooManyResultsException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
* This class represents the API for the service to safe the message.
* Each message is persisted in the database and can be edited or deleted.
*/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRepository implements Repository<Message> {
    private final Database database = Database.newInstance();

    public static MessageRepository of() {
        MessageRepository result = new MessageRepository();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Message entity) {
        database.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Message> findBy(int id) {
        return database.findBy(Message.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Message entity) {
        database.delete(entity);
    }

    /**
     * Returns a list of messages (under the condition of matching the predicate)
     *
     * @param predicate
     * @return List of messages, matching the predicate
     */
    public List<Message> findBy(Predicate<Message> predicate) {
        return database.findBy(Message.class, predicate);
    }

    /**
     * Merges all predicates and returns the results found using the merged predicate
     *
     * @param predicates multiple predicates or none
     * @return a list of messages using the merged predicates
     */
    @SafeVarargs
    public final List<Message> findBy(Predicate<Message>... predicates) {
        Predicate<Message> mergedPredicate = Arrays
                .stream(predicates)
                .reduce(Predicate::and)
                .orElse(x -> true);

        return findBy(mergedPredicate);
    }
}
