package de.fherfurt.news.service.core.persistence;

import de.fherfurt.news.service.utils.JPA;
import lombok.Getter;
import org.hibernate.InstantiationException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Repository<ENTITY extends BaseBusinessEntity> implements IRepository<ENTITY> {
    @Getter
    private final EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();

    @Getter
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

    @Override
    public void saveAll(Collection<ENTITY> newEntities) {
        getEntityManager().getTransaction().begin();

        for (ENTITY entry : newEntities)
            getEntityManager().persist(entry);

        getEntityManager().getTransaction().commit();
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

    @SuppressWarnings("unchecked")
    @Override
    public Collection<ENTITY> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM " + getType().getCanonicalName() + " e");

        return (Collection<ENTITY>) query.getResultList();
    }

    @Override
    public Optional<ENTITY> update(ENTITY entity) {
        try {
            getEntityManager().getTransaction().begin();
            final ENTITY savedEntity = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();

            return Optional.of(savedEntity);
        } catch (InstantiationException exception) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<ENTITY> entity = this.findBy(id);
        if (entity.isPresent()) {
            this.delete(entity.get());
        }
    }

    @Override
    public void delete(ENTITY entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception exception) {
            // TODO:
        }
    }

    @Override
    public void delete(List<ENTITY> entries) {
        try {
            getEntityManager().getTransaction().begin();

            for (ENTITY entry : entries) {
                getEntityManager().remove(entry);
            }

            getEntityManager().getTransaction().commit();
        } catch (Exception exception) {

        }
    }
}
