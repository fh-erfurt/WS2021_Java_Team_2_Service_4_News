package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.models.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * authors: Lisa Sluka, Lucian Gerasch, Celina Ludwigs & Benjamin Ehnes
 */

public class Filter {
    public static Predicate<MessageDto> withDateBefore(LocalDateTime localDateTime) {
        return message -> message.getPublishedAt().isBefore(localDateTime);
    }

    public static Predicate<MessageDto> withAuthor(Integer... authors) {
        return message -> Arrays.asList(authors).contains(message.getAuthor());
    }

    public static Predicate<MessageDto> withTopic(String... topics) {
        // TODO: this could fail
        return message -> Arrays.asList(topics).contains(message.getTopic());
    }



    /*
    public List<Message> filterByAuthor(List<Message> messages, int necessaryAuthor) {
        return messages.stream().filter(message -> message.hasAuthor(necessaryAuthor)).collect(Collectors.toList());
    }

    public List<Message> filterByBlacklistedAuthor(List<Message> messages, int blacklistedAuthor) {
        return messages.stream().filter(message -> !message.hasAuthor(blacklistedAuthor)).collect(Collectors.toList());
    }

    public List<Message> filterByFacultyAndGlobalNews(List<Message> messages, String necessaryFaculty) {
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty) || message.hasFaculty("AllFaculties")) {
                filteredMessages.add(message);
            }
        }

        return filteredMessages;
    }

    public List<Message> filterByFaculty(List<Message> messages, String necessaryFaculty) {
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty)) {
                filteredMessages.add(message);
            }
        }
        return filteredMessages;
    }

    public void removeMessagesFromFaculty(List<Message> messages, String blacklistedFaculty) {
        messages.removeIf(message -> message.hasFaculty(blacklistedFaculty));
    }

    public List<Message> filterByAppointmentName(List<Message> messages, String appointmentName) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (entry.matchesAppointmentName(appointmentName)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedAppointmentName(List<Message> messages, String blacklistedAppointmentName) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (!entry.matchesAppointmentName(blacklistedAppointmentName)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByPublishedAt(List<Message> messages, LocalDateTime necessaryPublishedAt) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (entry.wasPublishedAt(necessaryPublishedAt)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedPublishedAt(List<Message> messages, LocalDateTime blacklistedPublishedAt) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (!entry.wasPublishedAt(blacklistedPublishedAt)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByAppointmentDateTime(List<Message> messages, LocalDateTime necessaryAppointmentDateTime) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (entry.hasAppointmentDateTime(necessaryAppointmentDateTime)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedAppointmentDateTime(List<Message> messages, LocalDateTime blacklistedAppointmentDateTime) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (!entry.hasAppointmentDateTime(blacklistedAppointmentDateTime)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByTopic(List<Message> messages, String necessaryTopic) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (entry.hasTopic(necessaryTopic)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedTopic(List<Message> messages, String blacklistedTopic) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry -> {
            if (!entry.hasTopic(blacklistedTopic)) {
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }
    */

}
