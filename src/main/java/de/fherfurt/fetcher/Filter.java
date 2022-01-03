package de.fherfurt.fetcher;

import java.util.ArrayList;
import java.util.List;

/**
 * authors: Lisa Sluka, Lucian Gerasch & Benjamin Ehnes
 */

public class Filter {
    public List<Message> filterByAuthor(List<Message> messages, int necessaryAuthor){
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(entry.hasAuthor(necessaryAuthor)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedAuthor(List<Message> messages, int blacklistedAuthor) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(!entry.hasAuthor(blacklistedAuthor)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByFacultyAndGlobalNews(List<Message> messages, String necessaryFaculty){
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty) || message.hasFaculty("AllFaculties")) {
                filteredMessages.add(message);
            }
        }

        return filteredMessages;
    }

    public List<Message> filterByFaculty(List<Message> messages, String necessaryFaculty){
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty)) {
                filteredMessages.add(message);
            }
        }

        return filteredMessages;
    }

    public void removeMessagesFromFaculty(List<Message> messages, String blacklistedFaculty) {
        messages.removeIf(message -> message.hasFaculty(blacklistedFaculty));
    }
}
