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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(setterPrefix = "with")
public class Message extends BaseBusinessEntity {
    private int author;


    // private List<String> images = new ArrayList<>();

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
}
