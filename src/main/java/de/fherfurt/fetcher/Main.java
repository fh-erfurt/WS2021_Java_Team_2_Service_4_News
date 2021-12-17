package de.fherfurt.fetcher;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initializing
        Sort sort = new Sort();
        Filter filter = new Filter();
        Feed feed = new Feed(new URL("https://cdn.discordapp.com/attachments/870984798359924788/921411063864520744/messages.json"));

        // Creating the feed
        feed.fetch();
        feed.buildFeed();

        // Sorting the feed

        //sort.sortByDateAsc(feed.entries);
        //sort.sortByAppointmentDesc(feed.entries);

        //sort.sortByAppointmentAsc(feed.entries);
        //sort.sortByAppointmentDesc(feed.entries);

        //sort.sortByAuthorAZ(feed.entries);
        //sort.sortByAuthorZA(feed.entries);

        // Filtering the feed

        //filter.filterByAuthor(feed.entries,"Insert necessary Author");
        //filter.blacklistAuthor(feed.entries,"Enter blacklisted Author");
    }
}
