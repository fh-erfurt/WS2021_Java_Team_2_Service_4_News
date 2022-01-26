package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.core.models.Message;

import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.faculty.client.DevFacultyService;
import de.fherfurt.appointment.client.DevAppointmentService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Deprecated
public class  Main {
    public static void main(String[] args) throws IOException {
        MessageRepository messageRepository = MessageRepository.of();

        Filter filter = new Filter();
        filter.withAuthor(1);
        filter.withDateBefore(LocalDateTime.now());
        filter.withTopic("Hello");

        List<Message> messages = messageRepository.findBy(filter.build());

        for (Message message : messages) {
            MessageDto messageDto = BeanMapper.mapToDto(message);

            System.out.println(messageDto);
        }
    }
}
