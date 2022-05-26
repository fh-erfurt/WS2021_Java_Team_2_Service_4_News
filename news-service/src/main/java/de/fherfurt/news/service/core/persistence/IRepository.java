package de.fherfurt.news.service.core.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Basic API definition for a component that handles the persisting if a specific type. Special operations should be
 * defined and implemented in the explicit repository.
 *
 * @param <ENTITY> Generic type of entity
 */
public interface IRepository<ENTITY> {
    /**
     * Save an entity to the underlying storage. It doesn't matter, if the entity is new or already saved. In case of update
     * the changes are written too.
     *
     * @param entity Instance to save
     */
    void save(ENTITY entity);

    /**
     * Saves all entities to the underlying storage.
     *
     * @param newEntities
     */
    void saveAll(Collection<ENTITY> newEntities);
    /**
     * Find an entity by its id. If no entity is available, an empty {@link Optional} is returned.
     *
     * @param id Id of the searched entity
     * @return The entity or empty
     */
    Optional<ENTITY> findBy(Long id);


    Collection<ENTITY> findAll();

    /**
     * Deletes a given entity.
     *
     * @param entity Instance to delete
     */

    Optional<ENTITY> update(ENTITY entity);

    void delete(Long id);
    void delete(ENTITY entity);
    void delete(List<ENTITY> entries);
}
