package de.fherfurt.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


public class MessageDatabase implements Repository {
    private static MessageDatabase instance;

    private final Map<Integer, Message> cache = new ConcurrentHashMap<>();

    public static MessageDatabase newInstance() {
        if (Objects.isNull(instance)) {
            instance = new MessageDatabase();
        }

        return instance;
    }

    @Override
    public void delete(Integer key) {
        this.cache.remove(key);
    }

    @Override
    public boolean insert(Message message) {
        if (this.cache.containsKey(message.hashCode())) {
            this.cache.put(message.hashCode(), message);

            return true;
        }

        return false;
    }

    @Override
    public List<Message> get(String query) {
        return new ArrayList<Message>();
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }
}
