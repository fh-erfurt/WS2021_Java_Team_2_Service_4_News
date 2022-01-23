package de.fherfurt.news.service.persistence;

import java.time.LocalDateTime;

public record MessageDto(Integer Author,
                         String title,
                         String description,
                         String url,
                         String urlToImage,
                         LocalDateTime publishedAt,
                         String content,
                         String topic,
                         String faculty,
                         String appointmentName,
                         LocalDateTime appointmentDateTime) {
}
