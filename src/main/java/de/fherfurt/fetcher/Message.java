package de.fherfurt.fetcher;

import java.time.LocalDateTime;
import java.util.Objects;

// Person getPersonByName(String name)

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
public class Message {
    private int author;     // get name by id
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private String topic;
    private String faculty;  // FacultyService: getInformationFromName(String name);

    private String appointmentName;     // AppointmentService: createAppointment(String name, LocalDateTime appointDateTime);
    private LocalDateTime appointmentDateTime;

    public boolean hasAuthor(int author) {
        return this.author == author;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
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

    public boolean wasPublishedAt(LocalDateTime publishedAt) { return this.publishedAt.equals(publishedAt); }

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

    public boolean hasTopic(String topic) {
        return this.topic.equals(topic);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
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

    public Message(int author, String title, String description, String url, String urlToImage, LocalDateTime publishedAt, String content, String topic, String faculty, String appointmentName, LocalDateTime appointmentDateTime) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.topic = topic;
        this.faculty = faculty;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = appointmentDateTime;
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
                && Objects.equals(faculty, message.faculty)
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
                faculty,
                appointmentName,
                appointmentDateTime);
    }
}
