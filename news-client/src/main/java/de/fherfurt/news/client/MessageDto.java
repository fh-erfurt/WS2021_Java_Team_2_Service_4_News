package de.fherfurt.news.client;

import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDto that = (MessageDto) o;
        return author == that.author && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(images, that.images) && Objects.equals(publishedAt, that.publishedAt) && Objects.equals(content, that.content) && Objects.equals(topic, that.topic) && Objects.equals(faculty, that.faculty) && Objects.equals(appointmentName, that.appointmentName) && Objects.equals(appointmentDateTime, that.appointmentDateTime) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, description, url, images, publishedAt, content, topic, faculty, appointmentName, appointmentDateTime, id);
    }
}
