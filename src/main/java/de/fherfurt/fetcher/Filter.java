package de.fherfurt.fetcher;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private String necessaryAuthor;


    public static List<Message> filterMessageByAuthor(List<Message> messages, String necessaryAuthor){
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(entry.hasAuthor(necessaryAuthor)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }


}
