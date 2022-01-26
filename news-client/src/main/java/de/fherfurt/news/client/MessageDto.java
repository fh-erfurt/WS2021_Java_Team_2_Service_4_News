package de.fherfurt.news.client;

import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class MessageDto {
    private int id;
    private int author;
    private String title;
    private String description;
    private String url;
    //List<ImageDto> images;
    private LocalDateTime publishedAt;
    private String content;
    private String topic;
    private String faculty;
    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", faculty='" + faculty + '\'' +
                ", appointmentName='" + appointmentName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}
