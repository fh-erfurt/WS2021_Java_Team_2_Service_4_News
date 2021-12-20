package de.fherfurt.fetcher;

import java.util.Collections;
import java.util.List;

/**
 * authors: Lisa Sluka, Lucian Gerasch, Benjamin Ehnes
 */

public class Sort {
    public void sortByDateAsc(List<Message> messages){
        Collections.sort(messages,new MessageDateComparator());
    }
    public void sortByDateDesc(List<Message> messages) { Collections.sort(messages,Collections.reverseOrder(new MessageDateComparator())); }

    public void sortByAppointmentAsc(List<Message> messages) { Collections.sort(messages,new MessageAppointmentComparator()); }
    public void sortByAppointmentDesc(List<Message> messages) { Collections.sort(messages,Collections.reverseOrder(new MessageAppointmentComparator())); }

    public void sortByAuthorAZ(List<Message> messages, IPersonService personService) { Collections.sort(messages,new MessageAuthorComparator(personService)); }
    public void sortByAuthorZA(List<Message> messages, IPersonService personService) { Collections.sort(messages,Collections.reverseOrder(new MessageAuthorComparator(personService))); }

    public void sortByTopicASC(List<Message> messages)
    {
        Collections.sort(messages, new MessageTopicComparator());
    }

}
