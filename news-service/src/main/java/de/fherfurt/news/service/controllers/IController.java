package de.fherfurt.news.service.controllers;

import de.fherfurt.news.service.models.Message;

import java.util.List;
import java.util.function.Predicate;

/**
 * This class represents the supervising class in the service.
 *
 */
public interface IController {
    @SuppressWarnings("unchecked")
    List<Message> getItems(Integer amount, Predicate<Message>... predicates);

    public void insert(Message message);
}