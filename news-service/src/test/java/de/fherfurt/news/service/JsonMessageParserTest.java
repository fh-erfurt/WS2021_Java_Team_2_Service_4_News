
package de.fherfurt.news.service;

import de.fherfurt.news.service.models.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import org.json.JSONObject;


public class JsonMessageParserTest {

    @Test
    void testParseSingleMessageEmpty() {
        JSONObject jsonObject = new JSONObject();

        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }

    @Test
    void testParseSingleMessageEmptyAuthor() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "title");
        jsonObject.put("content", "content");
        jsonObject.put("publishedAt", "2021-12-31 23:59");


        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }


    @Test
    void testParseSingleMessageEmptyContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("author", 1);
        jsonObject.put("title", "title");
        jsonObject.put("publishedAt", "2021-12-31 23:59");


        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }

    @Test
    void testParseSingleMessageEmptyTitle() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("author", 1);
        jsonObject.put("content", "content");
        jsonObject.put("publishedAt", "2021-12-31 23:59");


        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }

    @Test
    void testParseSingleMessageEmptyPublishedAt() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("author", 1);
        jsonObject.put("content", "content");
        jsonObject.put("title", "title");


        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }

    @Test
    void testParseSingleMessageWrongPublishedAt() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("author", 1);
        jsonObject.put("content", "content");
        jsonObject.put("title", "title");
        jsonObject.put("publishedAt", "2021-12-31");


        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isEmpty());
    }

    @Test
    void testParseSingleMessageAllSet() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("author", 1);
        jsonObject.put("title", "title");
        jsonObject.put("content", "content");
        jsonObject.put("publishedAt", "2021-12-31 23:59");

        Optional<Message> optionalMessage = JsonMessageParser.parseSingleMessage(jsonObject);

        Assertions.assertTrue(optionalMessage.isPresent());
        Message message = optionalMessage.get();
        Assertions.assertEquals(1, message.getAuthor());
        Assertions.assertEquals("title", message.getTitle());
        Assertions.assertEquals("content", message.getContent());
        Assertions.assertEquals("2021-12-31T23:59", message.getPublishedAt().toString());
    }

}
