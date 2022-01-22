package de.fherfurt.news.client;

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

