package de.fherfurt.news.service;

import de.fherfurt.news.service.controllers.ItemsController;
import de.fherfurt.news.service.models.Message;
import de.fherfurt.persons.client.DevPersonService;

import de.fherfurt.faculty.client.DevFacultyService;

import de.fherfurt.appointment.client.DevAppointmentService;

import java.io.IOException;
import java.util.List;

@Deprecated
public class  Main {
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

        ItemsController itemsController = new ItemsController();

        itemsController.insert(Message.builder().withAuthor(1).withContent("Peace").build());
        itemsController.insert(Message.builder().withAuthor(2).withContent("Peace").build());
        itemsController.insert(Message.builder().withAuthor(3).withContent("Peace").build());
        itemsController.insert(Message.builder().withAuthor(4).withContent("Peace").build());
        itemsController.insert(Message.builder().withAuthor(5).withContent("Peace").build());

        List<Message> messages = itemsController.getItems(10, message -> message.getAuthor() > 1);

        for (Message each : messages) {
            System.out.println(each);
        }
    }
}
