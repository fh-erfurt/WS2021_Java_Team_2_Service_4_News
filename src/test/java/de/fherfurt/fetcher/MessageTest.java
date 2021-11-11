package de.fherfurt.fetcher;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testMessageWithAuthors() {
        // given
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Hanna");
        authors.add("Anna");

        // when
        Message message = new Message
                .Builder()
                .withAuthors(authors)
                .construct();

        // then
        Assertions.assertNotEquals(message.getAuthors().size(), 0);
    }
}
