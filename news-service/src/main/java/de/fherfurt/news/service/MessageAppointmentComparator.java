package de.fherfurt.news.service;

import java.util.Comparator;

public class MessageAppointmentComparator implements Comparator<Message> {

    @Override
    public int compare(Message lhs, Message rhs) {

        // returns null objects as greater than non-null objects to ensure that they are
        // displayed last when the feed is sorted by appointmentDateTime ascending

        if (lhs.getAppointmentDateTime() != null && rhs.getAppointmentDateTime() != null) {
            return lhs.getAppointmentDateTime().compareTo(rhs.getAppointmentDateTime());
        } else if (lhs.getAppointmentDateTime() == null && rhs.getAppointmentDateTime() == null) {
            return 0;
        } else if (lhs.getAppointmentDateTime() == null) {
            return 1;
        } else {
            return -1;
        }
    }

}
