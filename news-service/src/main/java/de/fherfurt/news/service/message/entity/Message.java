package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> images;
    private LocalDateTime publishedAt;
    private String content;
    private String topic;

    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    // desired redundancy
    private String fieldOfStudy;
    private String faculty;
    private String university;

    @Builder(setterPrefix = "with")
    public Message(int id, int author, String title, String description, String url, List<String> images, LocalDateTime publishedAt, String content, String topic, String appointmentName, LocalDateTime appointmentDateTime, String fieldOfStudy, String faculty, String university) {
        super(id);
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.images = images;
        this.publishedAt = publishedAt;
        this.content = content;
        this.topic = topic;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = appointmentDateTime;
        this.fieldOfStudy = fieldOfStudy;
        this.faculty = faculty;
        this.university = university;
    }
}
