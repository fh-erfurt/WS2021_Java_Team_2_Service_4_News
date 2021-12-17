package de.fherfurt.fetcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author: Lucian Gerasch
 * comment: All implemented tests are working and return the expected results.
 *          Tests regarding faculties are still WIP due to possible interfaces.
 */

class FilterTest {

    @Test
    void filterByAuthor() throws IOException {
        //given
        Feed given = new Feed(new URL("https://cdn.discordapp.com/attachments/870984798359924788/921411063864520744/messages.json"));
        given.fetch();
        Filter filter = new Filter();
        List<Message> filteredFeed = new ArrayList<Message>();

        //when
        filteredFeed = filter.filterByAuthor(given.entries, "Max Mustermann");

        //then
        Assertions.assertThat(filteredFeed)
                .isNotEmpty()
                .hasSize(1);
        filteredFeed.forEach(entry -> {assertTrue(entry.hasAuthor("Max Mustermann"));});
    }

    @Test
    void blacklistAuthor() throws IOException {
        Feed given = new Feed(new URL("https://cdn.discordapp.com/attachments/870984798359924788/921411063864520744/messages.json"));
        given.fetch();
        Filter filter = new Filter();
        List<Message> filteredFeed = new ArrayList<Message>();

        //when
        filteredFeed = filter.blacklistAuthor(given.entries, "Max Mustermann");

        //then
        Assertions.assertThat(filteredFeed)
                .isNotEmpty()
                .hasSize(4);
        filteredFeed.forEach(entry -> {assertTrue(!entry.hasAuthor("Max Mustermann"));});
    }

    // Faculties is still WIP

    /*
    @Test
    void filterByFaculty() {
    }

    @Test
    void blacklistFaculty() {
    }
    */
}