package de.fherfurt.news.service;

import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.models.Message;

import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.faculty.client.DevFacultyService;
import de.fherfurt.appointment.client.DevAppointmentService;

import java.io.IOException;
import java.util.List;

@Deprecated
public class  Main {
    public static void main(String[] args) throws IOException {
        MessageRepository messageRepository = MessageRepository.of();

        List<Message> messages = messageRepository.findBy(message -> message.getTopic().equals("Java"), message -> message.getAuthor() == 1);

        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
