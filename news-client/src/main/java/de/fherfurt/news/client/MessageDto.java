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
    int id;

    public void addImage(ImageDto imageDto) {
        this.images.add(imageDto);
    }
}
