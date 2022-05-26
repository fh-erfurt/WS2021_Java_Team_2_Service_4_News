package de.fherfurt.news.message.entity;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.boundary.MessageResource;
import de.fherfurt.news.service.message.entity.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Lisa Sluka, Benjamin Ehnes
 * */

/*
public class MessageResourceTest {

    @Test
    void findMessagesByTopic() throws Exception {
        //GIVEN

            MessageDto messageDto1 = MessageDto.builder()
                    .withId(3)
                    .withAuthor(1)
                    .withTopic("KI-Messe")
                    .withFaculty("Angewandte Informatik")
                    .build();

            MessageDto messageDto2 = MessageDto.builder()
                    .withId(4)
                    .withAuthor(1)
                    .withTopic("PartyHard")
                    .withFaculty("Angewandte Informatik")
                    .build();

            MessageResource messageResource = new MessageResource();

            //WHEN
            messageResource.save(messageDto1);
            messageResource.save(messageDto2);

            List<MessageDto> messagesFound = messageResource.findBy("KI-Messe","","","");

            //THEN
            Assertions.assertEquals(messagesFound.size(), 1);
    }

    @Test
    void findMessagesByFaculty() throws Exception {
        //GIVEN

        MessageDto messageDto1 = MessageDto.builder()
                .withId(3)
                .withAuthor(2)
                .withTopic("KI-Messe")
                .withFaculty("Angewandte Informatik")
                .build();

        MessageDto messageDto2 = MessageDto.builder()
                .withId(4)
                .withAuthor(2)
                .withTopic("Architektur PartyHard")
                .withFaculty("Angewandte Informatik")
                .build();

        MessageResource messageResource = new MessageResource();

        //WHEN
        messageResource.save(messageDto1);
        messageResource.save(messageDto2);

        List<MessageDto> messagesFound = messageResource.findBy("","","Angewandte Informatik","");

        //THEN
        Assertions.assertEquals(messagesFound.size(), 2);
    }

    @Test
    void createAppointmentTest() throws Exception {
        //GIVEN
        MessageDto messageDto1 = MessageDto.builder()
                .withId(3)
                .withAuthor(1)
                .withTopic("KI-Messe")
                .withFaculty("Angewandte Informatik")
                .withAppointmentDateTime(LocalDateTime.now())
                .withAppointmentName("Messetermin")
                .build();

        MessageDto messageDto2 = MessageDto.builder()
                .withId(4)
                .withAuthor(1)
                .withTopic("Sommerfest")
                .withFaculty("Angewandte Informatik")
                .build();

        MessageResource messageResource = new MessageResource();

        //WHEN
        messageResource.save(messageDto1);
        messageResource.save(messageDto2);

        boolean createdAppointment1 = messageResource.createAppointmentEntry(3);
        boolean createdAppointment2 = messageResource.createAppointmentEntry(4);

        //THEN
        Assertions.assertTrue(createdAppointment1);
        Assertions.assertFalse(createdAppointment2);

    }


}
*/
