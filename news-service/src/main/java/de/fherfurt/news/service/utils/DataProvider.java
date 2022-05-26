package de.fherfurt.news.service.utils;

import de.fherfurt.news.service.message.entity.Message;

import java.time.LocalDateTime;

public class DataProvider {
    public static Message createTestMessage(){

        Message message = Message.builder()
                .withAuthor(1)
                .withTitle("Party on!")
                .withDescription("Es wird wieder gefiert")
                .withContent("Am 17.06.2022 findet das Sommerfest der FH Erfurt statt. Zahlreiches erscheinen ist erwünscht!")
                .withAppointmentDateTime(LocalDateTime.of(2022, 06, 17, 17, 0))
                .withUniversity("FH Erfurt")
                .withPublishedAt(LocalDateTime.now())
                .withFaculty("all")
                .build();

        return message;
    }
}
