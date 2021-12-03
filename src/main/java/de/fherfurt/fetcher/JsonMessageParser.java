package de.fherfurt.fetcher;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JsonMessageParser {
    private String author;
    private String title;
    private String source;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private ArrayList<String> tags;
    private ArrayList<Faculty> faculties;

    private String appointmentName;
    private LocalDateTime appointmentDateTime;

    public JsonMessageParser(URL url) throws IOException {
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

        JSONObject jsonObject = new JSONObject(content);

        
    }

    public JsonMessageParser(JSONObject jsonObject) {
        this.author = jsonObject.getString("author");
        this.title = jsonObject.getString("title");
    }

    public Message constructMessage() {
        return new Message(
                author,
                title);
    }


}
