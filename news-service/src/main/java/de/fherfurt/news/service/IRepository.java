package de.fherfurt.news.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Basic definition of a database-abstraction used used to store and retrieve data.
 */
public interface IRepository<T> {
    /**
     * Function used to retrieve items from the repository. Represents the core of the API.
     *
     * @return returns a list of entities.
     */
    public List<T> getItems(Predicate<Message>... predicates);

    /**
     * Function used to retrieve a single item from the repository.
     *
     * @return returns a list of entities.
     */
    public Optional<T> getItem(UUID uuid);

    /**
     * Functions used to delete an entry from the repository.
     *
     * @param uuid Equals the id of an entity in the storage.
     */
    void delete(UUID uuid);

    void insert(T value);

    void update(UUID uuid, T value);

    void save();

    void clearCache();
}
