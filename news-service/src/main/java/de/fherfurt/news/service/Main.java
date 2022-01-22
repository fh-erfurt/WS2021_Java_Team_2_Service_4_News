package de.fherfurt.news.service;

import de.fherfurt.persons.client.DevPersonService;

import de.fherfurt.faculty.client.DevFacultyService;

import de.fherfurt.appointment.client.DevAppointmentService;

import java.io.IOException;

@Deprecated
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

        feed.buildFeed();


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
