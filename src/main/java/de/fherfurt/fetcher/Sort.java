package de.fherfurt.fetcher;

import java.util.Collections;
import java.util.List;

public class Sort {

    public static void sortByDateAsc(List<Message> messages){
        Collections.sort(messages,new MessageDateComparator());
    }
}
