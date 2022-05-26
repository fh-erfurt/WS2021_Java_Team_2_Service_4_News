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
    private int author;
    private String title;
    private String description;
    private String url;
    List<ImageDto> images;
    private LocalDateTime publishedAt;
    private String content;
    private String topic;
    private String faculty;
    private String appointmentName;
    private LocalDateTime appointmentDateTime;
    private Long id;

    public void addImage(ImageDto imageDto) {
        this.images.add(imageDto);
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", images=" + images +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", faculty='" + faculty + '\'' +
                ", appointmentName='" + appointmentName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", id=" + id +
                '}';
    }
}
