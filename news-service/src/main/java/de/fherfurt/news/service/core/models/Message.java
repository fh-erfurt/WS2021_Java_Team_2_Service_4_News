package de.fherfurt.news.service.core.models;

import de.fherfurt.news.service.core.models.Image;
import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Message extends BaseBusinessEntity {
    private int author;
    private String title;
    private String description;
    private String url;
    private List<Image> images;
    private LocalDateTime publishedAt;
    private String content;
    private String topic;
    private String faculty;
    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    @Builder(setterPrefix = "with")
    public Message(
            int id,
            int author,
            String title,
            String description,
            String url,
            List<Image> images,
            LocalDateTime publishedAt,
            String content,
            String topic,
            String faculty,
            String appointmentName,
            LocalDateTime appointmentDateTime
    ) {
        super(id);
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.images = images;
        this.publishedAt = publishedAt;
        this.content = content;
        this.topic = topic;
        this.faculty = faculty;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = appointmentDateTime;
    }

    /*
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
    */
}
