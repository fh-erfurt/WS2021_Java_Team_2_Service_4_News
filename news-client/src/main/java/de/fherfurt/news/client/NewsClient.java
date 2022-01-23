package de.fherfurt.news.client;


import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class NewsClient {
    // HttpClient

    private ServiceSettings serviceSettings;

    public record Message(
            Integer Author,
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

    public record Feed(Message[] messages) {}

    List<Message> fetchMessages(String faculty, Integer amount) {
        CompletableFuture.runAsync(() -> {
            // TODO: implement http fetch!
        });

        Message message = new Message(1, null, null, null, null, null, null, null, null, null, null);


        return new ArrayList<Message>();
    }
}
