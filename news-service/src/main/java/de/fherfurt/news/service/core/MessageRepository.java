package de.fherfurt.news.service.core;

import de.fherfurt.news.service.core.models.Message;
import de.fherfurt.news.service.core.persistence.Database;
import de.fherfurt.news.service.core.persistence.Repository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.prefs.PreferenceChangeEvent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRepository implements Repository<Message> {
    private final Database database = Database.newInstance();

    public static MessageRepository of() {
        MessageRepository result = new MessageRepository();

        result.init();

        return result;
    }

    private void init() {
        database.save(Message.builder().withId(1).withAuthor(1).withTopic("Java").withPublishedAt(LocalDateTime.now()).build());
        database.save(Message.builder().withId(2).withAuthor(2).withTopic("Java").withPublishedAt(LocalDateTime.now()).build());
    }

    @Override
    public void save(Message entity) {
        database.save(entity);
    }

    @Override
    public Optional<Message> findBy(int id) {
        return database.findBy(Message.class, id);
    }

    @Override
    public void delete(Message entity) {
        database.delete(entity);
    }

    @Override
    public List<Message> findBy(Predicate<Message> predicate) {
        return database.findBy(Message.class, predicate);
    }

    @SafeVarargs
    public final List<Message> findBy(Predicate<Message>... predicates) {
        Predicate<Message> mergedPredicate = Arrays
                .stream(predicates)
                .reduce(Predicate::and)
                .orElse(x -> true);

        return findBy(mergedPredicate);
    }
}
