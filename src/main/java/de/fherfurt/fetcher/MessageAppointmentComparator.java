package de.fherfurt.fetcher;

import java.util.Comparator;

public class MessageAppointmentComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {
        return lhs.getAppointmentDateTime().compareTo(rhs.getAppointmentDateTime());
    }
}
