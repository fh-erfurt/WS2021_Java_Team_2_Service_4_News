package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;

import lombok.*;

import javax.persistence.*;
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
@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private int author;



    // @Column(name="Author", length = 50, nullable = false, unique = false)
    // private List<String> images = new ArrayList<>();

    public Message(int author) {
        this.author = author;
    }

    /*
    private String title;
    private String description;
    private String url;

    private LocalDateTime publishedAt;
    private String content;
    private String topic;

    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    // desired redundancy
    private String fieldOfStudy;
    private String faculty;
    private String university;
    */

    /*
    @Builder(setterPrefix = "with")
    public Message(int author, String title, String description, String url, List<String> images, LocalDateTime publishedAt, String content, String topic, String appointmentName, LocalDateTime appointmentDateTime, String fieldOfStudy, String faculty, String university) {
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
    */
}
