package de.fherfurt.fetcher;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initializing
        Sort sort = new Sort();
        Filter filter = new Filter();

        DevPersonService personService = new DevPersonService();
        DevFacultyService facultyService = new DevFacultyService();
        DevAppointmentService appointmentService = new DevAppointmentService();

        /*
        Feed feed = new Feed(
                new URL("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json"),
                personService,
                facultyService,
                appointmentService);
        */

        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_fac.json");


        // Creating the feed
        feed.fetch();
        //feed.buildFeed();

        feed.addAppointments();

        // Sorting the feed

        System.out.println(feed.getEntries());


        //feed.buildFeed();

        //sort.sortByAppointmentDesc(feed.entries);

        //sort.sortByAppointmentAsc(feed.getEntries());

        //feed.buildFeed();

        //sort.sortByAppointmentDesc(feed.getEntries());

        //feed.buildFeed();

        //List<Message> messages = filter.filterByFaculty(feed.getEntries(), "Gebaeudetechnik_und_Informatik");

        //System.out.println(messages);

        //feed.buildFeed();

        //sort.sortByAuthorAZ(feed.getEntries(), feed.getPersonService());
        //sort.sortByAuthorZA(feed.entries);

        // Filtering the feed

        //filter.filterByAuthor(feed.entries,"Insert necessary Author");
        //filter.blacklistAuthor(feed.entries,"Enter blacklisted Author");


    }
}
