package de.fherfurt.fetcher;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Feed {
    List<Message> entries = new ArrayList<Message>();
    URL url;

    public Feed(URL url) {
        this.url = url;
    }

    public void fetch() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        InputStream inputStream = url.openStream();
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } finally {
            inputStream.close();
        }

        String content = stringBuilder.toString();

        // json file could fail
        JSONObject jsonObject = new JSONObject(content);

        List<Message> messages = JsonMessageParser.parseJsonFile(jsonObject);

        entries = JsonMessageParser.parseJsonFile(jsonObject);
    }

    public void buildFeed() {
        AtomicInteger index = new AtomicInteger();
        index.set(1);
        entries.forEach(entry ->{
            System.out.println("\n---------- Message " + index.getAndIncrement() + " ----------");
            System.out.println("Author: " + entry.getAuthor());
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Description: " + entry.getDescription());
            System.out.println("URL: " + entry.getUrl());
            System.out.println("ImageURL: " + entry.getUrlToImage());
            System.out.println("Published at: " + entry.getPublishedAt());
            System.out.println("Content: " + entry.getContent());
            System.out.println("Topic: " + entry.getTopic());
            System.out.println("Name of appointment: " + entry.getAppointmentName());
            System.out.println("Date of appointment: " + entry.getAppointmentDateTime());
        });
    }
}

