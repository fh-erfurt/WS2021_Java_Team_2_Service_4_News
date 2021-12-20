package de.fherfurt.fetcher;

import java.util.Comparator;

public class MessageAuthorComparator implements Comparator<Message> {
    IPersonService personService;

    public MessageAuthorComparator(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public int compare(Message lhs, Message rhs) {
        return personService.getLastNameFromId(lhs.getAuthor()).compareTo(personService.getLastNameFromId(rhs.getAuthor()));
    }
}
