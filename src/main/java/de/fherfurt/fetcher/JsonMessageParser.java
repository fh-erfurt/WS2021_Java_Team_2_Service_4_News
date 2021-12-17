package de.fherfurt.fetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public static boolean hasValidDateTimeFormat(String value) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(value, dateTimeFormatter);

            String result = localDateTime.format(dateTimeFormatter);

            return result.equals(value);
        } catch (DateTimeParseException exception) {
            return false;
        }
    }

    public static Optional<LocalDateTime> convertStringToOptionalLocalDateTime(String value) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(value, dateTimeFormatter);

            return Optional.of(localDateTime);
        } catch (DateTimeParseException exception) {
            return Optional.empty();
        }
    }

    /**
     * Function extracts all necessary fields from a JSON-file and builds a Message.
     *
     * @param jsonObject Represents an Object extracted from a JSON-file
     * @return Returns an Optional of Message. If properly parsed contains a value
     */
    public static Optional<Message> parseSingleMessage(JSONObject jsonObject) {
        // necessary objects
        if (!jsonObject.has("author") || !jsonObject.has("title") || !jsonObject.has("content") || !jsonObject.has("publishedAt")) {
            // if not present, return an empty
            return Optional.empty();
        } else {
            // extract necessary objects
            String author = jsonObject.getString("author");
            String title = jsonObject.getString("title");
            String content = jsonObject.getString("content");

            // if not properly present, return an empty
            if (Objects.equals(author, "") || Objects.equals(title, "") || Objects.equals(content, "")) {
                return Optional.empty();
            }

            // extract other fields // if not present, default them to "Unknown"
            String description = jsonObject.has("description") ? jsonObject.getString("description") : "Unknown";
            String url = jsonObject.has("url") ? jsonObject.getString("url") : "Unknown";
            String urlToImage = jsonObject.has("urlToImage") ? jsonObject.getString("urlToImage") : "Unknown";

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String publishedAt = jsonObject.has("publishedAt") ? jsonObject.getString("publishedAt") : "INVALID";   // LocalDateTime

            // if the publishedAt-Date is not in valid format we return an empty
            if (!hasValidDateTimeFormat(publishedAt)) {
                return Optional.empty();
            }
            
            LocalDateTime publishedAtLocalDateTime = LocalDateTime.parse(publishedAt, dateTimeFormatter);

            String topic = jsonObject.has("topic") ? jsonObject.getString("topic") : "Unknown";
            String appointmentName = jsonObject.has("appointmentName") ? jsonObject.getString("appointmentName") : "Unknown";
            String appointmentDateTime = jsonObject.has("appointmentDateTime") ? jsonObject.getString("appointmentDateTime") : "0000-00-00 00:00";

            LocalDateTime appointmentLocalDateTime = LocalDateTime.parse(appointmentDateTime,dateTimeFormatter);

            // return new Optional with value
            return Optional.of(
                    new Message(author, title, description, url, urlToImage, publishedAtLocalDateTime, content, topic, appointmentName, appointmentLocalDateTime)
            );
        }
    }

    /**
     *
     *
     * @param messageArray
     * @return
     *
     * author: Antonia Geschke
     */
    public static List<Message> parseMessages(JSONArray messageArray) {
        List<Message> messages = new ArrayList<Message>();

        if (messageArray != null) {
            messageArray.forEach((item)->{
                Optional<Message> message = JsonMessageParser.parseSingleMessage((JSONObject)item);
                message.ifPresent((value) -> {
                    messages.add(value);
                });
            });
        }

        return messages;
    }

    public static List<Message> parseJsonFile(JSONObject jsonFile) {
        List<Message> messages = new ArrayList<Message>();

        if (jsonFile.has("Messages")) {
            JSONArray jsonMessages = jsonFile.getJSONArray("Messages");

            List<Message> extractedMessages = parseMessages(jsonMessages);

            messages.addAll(extractedMessages);
        }

        return messages;
    }
}
