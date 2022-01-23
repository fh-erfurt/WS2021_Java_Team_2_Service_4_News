package de.fherfurt.news.service;

import java.util.List;
import java.util.function.Predicate;

/**
 * This class represents the supervising class in the service.
 *
 */
public interface IController {
    @SuppressWarnings("unchecked")
    List<Message> getItems(Predicate<Message>... predicates);
}