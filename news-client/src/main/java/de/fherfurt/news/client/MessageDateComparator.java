package de.fherfurt.news.client;

import java.util.Comparator;

public class MessageDateComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getPublishedAt().compareTo(rhs.getPublishedAt());
    }
}
