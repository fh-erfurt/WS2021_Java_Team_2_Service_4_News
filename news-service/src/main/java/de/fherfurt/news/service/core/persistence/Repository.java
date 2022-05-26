package de.fherfurt.news.service.core.persistence;

import de.fherfurt.news.service.JPA;
import de.fherfurt.news.service.message.entity.Message;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public class Repository<ENTITY> implements IRepository<ENTITY> {
    private final EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
    private final Class<ENTITY> type;

    public Repository(Class<ENTITY> type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(ENTITY entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ENTITY> findBy(Long id) {
        try {
            ENTITY entity = entityManager.find(this.type, id);

            return Optional.of(entity);
        } catch (Exception exception) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(ENTITY entity) {

    }
}
