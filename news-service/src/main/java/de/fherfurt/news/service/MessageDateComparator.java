package de.fherfurt.news.service;

import de.fherfurt.news.service.models.Message;

import java.util.Comparator;

public class MessageDateComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getPublishedAt().compareTo(rhs.getPublishedAt());
    }
}
