package de.fherfurt.fetcher;

import java.util.Comparator;

public class MessageAuthorComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getAuthor().compareTo(rhs.getAuthor());
    }
}
