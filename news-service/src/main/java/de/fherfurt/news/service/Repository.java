package de.fherfurt.news.service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Basic definition of our exposed API.
 *
 */
public interface Repository {
    void delete(Integer key);

    boolean insert(Message message);

    List<Message> get(LocalDateTime from, Integer amount, String sortBy);

    boolean update();

    boolean save();
}
