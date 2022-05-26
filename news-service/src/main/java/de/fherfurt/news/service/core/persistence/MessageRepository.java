package de.fherfurt.news.service.core.persistence;

import de.fherfurt.news.service.JPA;
import de.fherfurt.news.service.message.entity.Message;

import javax.persistence.EntityManager;
import java.util.Optional;

public class MessageRepository implements IRepository<Message> {
    private final Class<Message> type = Message.class;
    private final EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();

    @Override
    public void save(Message message) {
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<Message> findBy(Long id) {
        try {
            Message entity = this.entityManager.find(this.type, id);

            return Optional.of(entity);
        } catch (Exception exception) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Message message) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(message);
        this.entityManager.getTransaction().commit();
    }

    public void deleteById(Long id) {

    }
}
