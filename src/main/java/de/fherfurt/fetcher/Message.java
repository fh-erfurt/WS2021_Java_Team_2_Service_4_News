package de.fherfurt.fetcher;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Person getPersonByName(String name)

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
public class Message {
    private String author;
    private String source;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private ArrayList<String> tags;
    private ArrayList<Faculty> faculties;

    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    public Message(String source,
                   String title,
                   String description,
                   String url,
                   String urlToImage,
                   LocalDateTime publishedAt,
                   String content,
                   ArrayList<String> tags,
                   ArrayList<Faculty> faculties,
                   String appointmentName,
                   LocalDateTime appointmentDateTime) {
        this.source = source;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.tags = tags;
        this.faculties = faculties;
        this.appointmentName = appointmentName;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Message(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
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

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Author: " + author + "Title: " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(author, message.author)
                && Objects.equals(source, message.source)
                && Objects.equals(title, message.title)
                && Objects.equals(description, message.description)
                && Objects.equals(url, message.url)
                && Objects.equals(urlToImage, message.urlToImage)
                && Objects.equals(publishedAt, message.publishedAt)
                && Objects.equals(content, message.content)
                && Objects.equals(tags, message.tags)
                && Objects.equals(faculties, message.faculties)
                && Objects.equals(appointmentName, message.appointmentName)
                && Objects.equals(appointmentDateTime, message.appointmentDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                author,
                source,
                title,
                description,
                url,
                urlToImage,
                publishedAt,
                content,
                tags,
                faculties,
                appointmentName,
                appointmentDateTime);
    }
}
