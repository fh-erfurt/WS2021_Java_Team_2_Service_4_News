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

        /*
    public List<Message> filterByFaculty(List<Message> messages, String necessaryFaculty){
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(entry.hasAuthor(necessaryFaculty)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> blacklistFaculty(List<Message> messages, String blacklistedFaculty) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(!entry.hasAuthor(blacklistedFaculty)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }
    */
}
