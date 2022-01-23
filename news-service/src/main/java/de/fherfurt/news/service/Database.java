package de.fherfurt.news.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Database implements IRepository<Message> {
    private static Database instance;

    private final Map<UUID, Message> cache = new ConcurrentHashMap<>();

    public static Database instance() {
        if (Objects.isNull(instance)) {
            instance = new Database();
        }

        return instance;
    }

    @Override
    public List<Message> getItems(Predicate<Message>... predicates) {
        // unfold all variadic templates
        List<Predicate<Message>> expandedPredicates = Arrays.stream(predicates).toList();

        // filter all messages using the templates
        return cache.values().stream()
                .filter(expandedPredicates.stream().reduce(predicate -> true, Predicate::and))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Message> getItem(UUID uuid) {
        return Optional.ofNullable(this.cache.get(uuid));
    }

    @Override
    public void delete(UUID uuid) {
        this.cache.remove(uuid);
    }

    @Override
    public void insert(Message message) {
        this.cache.put(UUID.randomUUID(), message);
    }

    @Override
    public void update(UUID uuid, Message message) {
        Optional<Message> entry = getItem(uuid);

        if (entry.isPresent()) {
            this.cache.replace(uuid, message);
        } else {
            // log
        }
    }

    @Override
    public void save() {
        // TODO: implement!
    }

    @Override
    public void clearCache() {
        // TODO: implement!
    }
}
