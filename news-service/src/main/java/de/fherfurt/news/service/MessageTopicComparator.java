package de.fherfurt.news.service;

import de.fherfurt.news.service.models.Message;

import java.util.Comparator;

/**
 * author: Antonia Geschke
 */

public class MessageTopicComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getTopic().compareTo(rhs.getTopic());
    }

}

