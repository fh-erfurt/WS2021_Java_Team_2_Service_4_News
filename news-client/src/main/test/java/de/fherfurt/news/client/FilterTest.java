package de.fherfurt.news.client;

import de.fherfurt.news.client.Filter;
import de.fherfurt.news.client.Message;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilterTest {

    @Test
    void filterByAuthorTest() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByAuthor(messages, 1);

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        Message message = filteredMessages.get(0);

        org.junit.jupiter.api.Assertions.assertTrue(message.hasAuthor(1));
    }

    @Test
    void filterByBlacklistedAuthor() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByBlacklistedAuthor(messages, 1);

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasAuthor(1));
        }
    }

    /**
     * author: Lisa Sluka
     */

    @Test
    void filterByFaculty() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByFaculty(messages, "Gebaeudetechnik_und_Informatik");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(2);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasFaculty("Gebaeudetechnik_und_Informatik"));
        }


    }

    @Test
    void filterByFacultyAndGlobalNews() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByFacultyAndGlobalNews(messages, "Gebaeudetechnik_und_Informatik");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(3);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasFaculty("Gebaeudetechnik_und_Informatik") || message.hasFaculty("AllFaculties"));
        }
    }

    /**
     * author: Benjamin Ehnes
     */
    @Test
    void removeMessagesFromFaculty() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        filter.removeMessagesFromFaculty(messages, "Gebaeudetechnik_und_Informatik");

        //then
        Assertions.assertThat(messages).isNotEmpty().hasSize(3);

        for (Message message : messages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasFaculty("Gebaeudetechnik_und_Informatik"));
        }
    }

    /**
     * author: Celina Ludwigs
     *
    */
    @Test
    void filterByAppointmentName() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByAppointmentName(messages, "Helden basteln");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.matchesAppointmentName("Helden basteln"));
        }
    }

    @Test
    void filterByBlacklistedAppointmentName() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Filter filter = new Filter();

        //when
        List<Message> filteredMessages = filter.filterByBlacklistedAppointmentName(messages, "Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4); // oder 1,da andere messages ohne appointmentName

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.matchesAppointmentName("Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'"));
        }
    }


    @Test
    void filterByPublishedAt() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //when
        List<Message> filteredMessages = filter.filterByPublishedAt(messages, LocalDateTime.parse("2021-12-08 09:30", dateTimeFormatter));

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.wasPublishedAt(LocalDateTime.parse("2021-12-08 09:30", dateTimeFormatter)));
        }
    }


    @Test
    void filterByBlacklistedPublishedAt() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //when
        List<Message> filteredMessages = filter.filterByBlacklistedPublishedAt(messages, LocalDateTime.parse("2021-10-02 17:42", dateTimeFormatter));

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.wasPublishedAt(LocalDateTime.parse("2021-10-02 17:42", dateTimeFormatter)));
        }
    }

    @Test
    void filterByAppointmentDateTime() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //when
        List<Message> filteredMessages = filter.filterByAppointmentDateTime(messages, LocalDateTime.parse("2021-12-12 14:00", dateTimeFormatter));

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasAppointmentDateTime(LocalDateTime.parse("2021-12-12 14:00", dateTimeFormatter)));
        }
    }

    @Test
    void filterByBlacklistedAppointmentDateTime() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //when
        List<Message> filteredMessages = filter.filterByBlacklistedAppointmentDateTime(messages, LocalDateTime.parse("2021-11-25 17:00", dateTimeFormatter));

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4); //oder 1,da andere messages ohne appointmentDateTime

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasAppointmentDateTime(LocalDateTime.parse("2021-11-25 17:00", dateTimeFormatter)));
        }
    }

    @Test
    void filterByTopic() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByTopic(messages, "Wissenschaft und Forschung");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(2);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasTopic("Wissenschaft und Forschung"));
        }
    }

    @Test
    void filterByBlacklistedTopic() {
        //given
        Filter filter = new Filter();
        List<Message> messages = TestResources.getTestMessageList();

        //when
        List<Message> filteredMessages = filter.filterByBlacklistedTopic(messages, "Architektur");

        //then
        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasTopic("Architektur"));
        }
    }
}
