package de.fherfurt.news.service;

import de.fherfurt.news.service.Feed;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

/**
 * @author Lisa Sluka, Benjamin Ehnes (Support)
 */
public class FeedTest {
    @Test
    void testFetchFromValidUrl() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_fac.json");
        feed.fetch();

        Assertions.assertThat(feed.getEntries()).hasSize(5);
    }

    @Test
    void testFetchFromNonValidUrl() {
        Feed feed = new Feed("random_shizzle");
        feed.fetch();

        Assertions.assertThat(feed.getEntries()).isEmpty();
    }
}
