package de.fherfurt.fetcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class FilterTest {
    @Test
    void filterByAuthorTest() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByAuthor(messages, 1);

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        Message message = filteredMessages.get(0);

        org.junit.jupiter.api.Assertions.assertTrue(message.hasAuthor(1));
    }

    @Test
    void filterByBlacklistedAuthor() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByBlacklistedAuthor(messages, 1);

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasAuthor(1));
        }
    }
}
