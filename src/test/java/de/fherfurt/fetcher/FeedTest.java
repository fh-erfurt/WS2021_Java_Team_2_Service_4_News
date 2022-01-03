package de.fherfurt.fetcher;


import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

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
