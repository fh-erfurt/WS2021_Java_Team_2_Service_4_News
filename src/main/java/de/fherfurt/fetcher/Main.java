package de.fherfurt.fetcher;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initializing
        Sort sort = new Sort();
        Filter filter = new Filter();

        DevPersonService personService = new DevPersonService();
        DevFacultyService facultyService = new DevFacultyService();
        DevAppointmentService appointmentService = new DevAppointmentService();

        Feed feed = new Feed(
                new URL("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json"),
                personService,
                facultyService,
                appointmentService);

        // Creating the feed
        feed.fetch();
        feed.buildFeed();

        feed.addAppointments();

        // Sorting the feed

        //sort.sortByDateAsc(feed.entries);
        //sort.sortByAppointmentDesc(feed.entries);

        sort.sortByAppointmentAsc(feed.getEntries());
        feed.buildFeed();
        sort.sortByAppointmentDesc(feed.getEntries());
        feed.buildFeed();

        //sort.sortByAuthorAZ(feed.getEntries(), feed.getPersonService());
        //sort.sortByAuthorZA(feed.entries);

        // Filtering the feed

        //filter.filterByAuthor(feed.entries,"Insert necessary Author");
        //filter.blacklistAuthor(feed.entries,"Enter blacklisted Author");
    }
}
