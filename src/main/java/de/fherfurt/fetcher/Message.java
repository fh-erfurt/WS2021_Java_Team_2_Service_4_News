package de.fherfurt.fetcher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

// Person getPersonByName(String name)

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
public class Message {
    private String author;  // Interface?! // String oder Id?!
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private String topic;
    private ArrayList<Faculty> faculties;   // Interface?!

    private String appointmentName;     // AppointmentService: createAppointment(String name, LocalDateTime appointDateTime);
    private Optional<LocalDateTime> appointmentDateTime;

    public Message(String author,
                   String title,
                   String description,
                   String url,
                   String urlToImage,
                   LocalDateTime publishedAt,
                   String content,
                   String topic,
                   ArrayList<Faculty> faculties,
                   String appointmentName,
                   LocalDateTime appointmentDateTime) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.topic = topic;
        this.faculties = faculties;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = Optional.of(appointmentDateTime);
    }

    public Message(String author,
                   String title,
                   String description,
                   String url,
                   String urlToImage,
                   LocalDateTime publishedAt,
                   String content,
                   String topic,
                   String appointmentName,
                   LocalDateTime appointmentDateTime
    ) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.topic = topic;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = Optional.of(appointmentDateTime);
    }

    public Message(String author,
                   String title,
                   String description,
                   String url,
                   String urlToImage,
                   LocalDateTime publishedAtLocalDateTime,
                   String content,
                   String topic,
                   String appointmentName,
                   Optional<LocalDateTime> appointmentLocalDateTime) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAtLocalDateTime;
        this.content = content;
        this.topic = topic;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = appointmentLocalDateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public Optional<LocalDateTime> getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = Optional.of(appointmentDateTime);
    }

    public boolean hasAppointmentAssociated() {
        return this.appointmentDateTime.isPresent();
    }

    @Override
    public String toString() {
        return "Message{" +
                "author: '" + author + '\'' +
                ", title: '" + title + '\'' +
                ", description: '" + description + '\'' +
                ", url: '" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt.toString() +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", faculties=" + faculties +
                ", appointmentName='" + appointmentName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(author, message.author)
                && Objects.equals(title, message.title)
                && Objects.equals(description, message.description)
                && Objects.equals(url, message.url)
                && Objects.equals(urlToImage, message.urlToImage)
                && Objects.equals(publishedAt, message.publishedAt)
                && Objects.equals(content, message.content)
                && Objects.equals(topic, message.topic)
                && Objects.equals(faculties, message.faculties)
                && Objects.equals(appointmentName, message.appointmentName)
                && Objects.equals(appointmentDateTime, message.appointmentDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                author,
                title,
                description,
                url,
                urlToImage,
                publishedAt,
                content,
                topic,
                faculties,
                appointmentName,
                appointmentDateTime);
    }
}
