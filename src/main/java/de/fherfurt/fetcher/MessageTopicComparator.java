package de.fherfurt.fetcher;

import java.util.Comparator;


public class MessageTopicComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getTopic().compareTo(rhs.getTopic());
    }

}

