package de.fherfurt.news.service;

import de.fherfurt.persons.client.IPersonService;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * authors: Lisa Sluka, Lucian Gerasch, Benjamin Ehnes, Antonia Geschke
 */

public class Sort {
    public void sortByDateAsc(List<Message> messages){
        messages.sort(Comparator.comparing(Message::getPublishedAt));
    }

    public void sortByDateDesc(List<Message> messages) {
        //return messages.stream().sorted(Comparator.comparing(Message::getPublishedAt).reversed()).collect(Collectors.toList());

        messages.sort(Comparator.comparing(Message::getPublishedAt).reversed());
    }

    public void sortByAppointmentAsc(List<Message> messages) { Collections.sort(messages, new MessageAppointmentComparator()); }
    public void sortByAppointmentDesc(List<Message> messages) { Collections.sort(messages,Collections.reverseOrder(new MessageAppointmentComparator())); }

    public void sortByAuthorAZ(List<Message> messages, IPersonService personService) { Collections.sort(messages,new MessageAuthorComparator(personService)); }
    public void sortByAuthorZA(List<Message> messages, IPersonService personService) { Collections.sort(messages,Collections.reverseOrder(new MessageAuthorComparator(personService))); }

    public void sortByTopicAsc(List<Message> messages) { Collections.sort(messages,Comparator.nullsLast(new MessageTopicComparator()));}
    public void sortByTopicDesc(List<Message> messages) { Collections.sort(messages,Comparator.nullsLast(Collections.reverseOrder(new MessageTopicComparator()))); }

}
