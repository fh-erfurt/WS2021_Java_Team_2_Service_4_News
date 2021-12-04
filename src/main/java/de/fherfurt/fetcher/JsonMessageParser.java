package de.fherfurt.fetcher;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;

public class JsonMessageParser {
    private String author;
    private String title;
    private String source;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDateTime publishedAt;
    private String content;

    private ArrayList<String> topic;
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

        System.out.println(content);
    }

    // macht das Sinn?!
    private enum ParserResult {
        FAILED_TO_PARSE_APPOINTMENT_DATE_TIME,
        FAILED_TO_PARSE_NECESSARY_FIELD
    }

    public static boolean hasValidDateTimeFormat(String format, String value) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(value, dateTimeFormatter);

            String result = localDateTime.format(dateTimeFormatter);

            return result.equals(value);
        } catch(DateTimeParseException exception) {
            return false;
        }
    }

    public static Message parseSingleMessage(JSONObject jsonObject) {
        if (!jsonObject.has("author") || !jsonObject.has("title") ||!jsonObject.has("content")) {
            return null;
        } else {
            String author = jsonObject.getString("author");
            String title = jsonObject.getString("title");
            String content = jsonObject.getString("content");

            if (Objects.equals(author, "") || Objects.equals(title, "") || Objects.equals(content, "")) {
                return null;
            }

            String description = jsonObject.has("description") ? jsonObject.getString("description") : "Unknown";
            String url = jsonObject.has("url") ? jsonObject.getString("url") : "Unknown";
            String urlToImage = jsonObject.has("urlToImage") ? jsonObject.getString("urlToImage") : "Unknown";

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String publishedAt = jsonObject.has("publishedAt") ? jsonObject.getString("publishedAt") : "Unknown";   // LocalDateTime

            LocalDateTime publishedAtLocalDateTime = LocalDateTime.parse(publishedAt, dateTimeFormatter);

            String topic = jsonObject.has("topic") ? jsonObject.getString("topic") : "Unknown";
            String appointmentName = jsonObject.has("appointmentName") ? jsonObject.getString("appointmentName") : "Unknown";
            String appointmentDateTime = jsonObject.has("appointmentDateTime") ? jsonObject.getString("appointmentDateTime") : "0000-00-00 00:00";

            LocalDateTime appointmentLocalDateTime = LocalDateTime.parse(appointmentDateTime, dateTimeFormatter);

            return new Message(
                    author,
                    title,
                    description,
                    url,
                    urlToImage,
                    publishedAtLocalDateTime,
                    content,
                    topic,
                    appointmentName,
                    appointmentLocalDateTime);
        }
    }
}
