package de.fherfurt.fetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String jsonContent = "{\n" +
                "    \"Messages\": [\n" +
                "        {\n" +
                "            author: \"Hanna Mueller\",\n" +
                "            \"title\": \"Gratis Nachhilfe für Studierende der FH-Erfurt in Mathematik!\",\n" +
                "        },\n" +
                "        {\n" +
                "            author: \"Hanna Mueller\",\n" +
                "           \"title\": \"Gratis Nachhilfe für Studierende der FH-Erfurt in Mathematik!\",\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONObject jsonMessages = new JSONObject(jsonContent);

        JSONArray messages = jsonMessages.getJSONArray("Messages");

        Feed feed = new Feed(jsonMessages);

        feed.print();

        feed.printHashCodes();

        JsonMessageParser jsonMessageParserFromURL = new JsonMessageParser(new URL("https://cdn.discordapp.com/attachments/906109518142918688/916348549011218462/messages.json"));


    }
}
