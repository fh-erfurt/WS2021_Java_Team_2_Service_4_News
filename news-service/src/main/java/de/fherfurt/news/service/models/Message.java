package de.fherfurt.news.service.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

// Person getPersonByName(String name)

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
@Getter
@Setter
@Builder(setterPrefix="with")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode
public class Message {
    private int author;     // get name by id
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private String topic;
    private String faculty;  // FacultyService: getInformationFromName(String name);

    private String appointmentName;     // AppointmentService: createAppointment(String name, LocalDateTime appointDateTime);
    private LocalDateTime appointmentDateTime;

    public boolean hasAuthor(int author) {
        return this.author == author;
    }

    public int getAuthor() {
        return author;
    }

    public boolean wasPublishedAt(LocalDateTime publishedAt) { return this.publishedAt.equals(publishedAt); }

    public boolean hasTopic(String topic) {
        return this.topic.equals(topic);
    }

    public boolean hasFaculty(String faculty) {
        return this.faculty.equals(faculty);
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public boolean hasAppointmentDateTime(LocalDateTime appointmentDateTime) {
        if (this.appointmentDateTime == null) {
            return false;
        }

        return this.appointmentDateTime.equals(appointmentDateTime);
    }

    public boolean matchesAppointmentName(String appointmentName) {
        if ((this.appointmentName != null) && (this.appointmentName.contains(appointmentName))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAppointmentAssociated() {
        return this.appointmentDateTime != null && this.appointmentName != null;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author: '" + author + '\'' +
                ", title: '" + title + '\'' +
                ", description: '" + description + '\'' +
                ", url: '" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", faculties=" + faculty +
                ", appointmentName='" + appointmentName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}
