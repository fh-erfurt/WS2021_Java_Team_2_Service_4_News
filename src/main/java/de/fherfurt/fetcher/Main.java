package de.fherfurt.fetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.sound.midi.SysexMessage;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String jsonContent = "{\n" +
                "  \"Messages\": [\n" +
                "    {\n" +
                "      \"author\": \"Max Müller\",\n" +
                "      \"title\": \"Tolle Neuigkeiten\",\n" +
                "      \"description\": \"Wir haben tolle Neuigkeiten\",\n" +
                "      \"url\": \"https://www.fh-erfurt.de/news/detailansicht/fh-erfurt-macht-mobil\",\n" +
                "      \"urlToImage\": \"https://www.fh-erfurt.de/news/detailansicht/fh-erfurt-macht-mobil\",\n" +
                "      \"publishedAt\": \"2022-12-03 10:30\",\n" +
                "      \"content\": \"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\",\n" +
                "      \"topic\": \"Veranstaltungen\",\n" +
                "      \"appointmentName\": \"Tag der Mobilität\",\n" +
                "      \"appointmentDateTime\": \"2022-07-30 10:30\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        JSONObject jsonMessages = new JSONObject(jsonContent);

        JSONArray messages = jsonMessages.getJSONArray("Messages");

        messages.forEach(item -> {
                    Message message = JsonMessageParser.parseSingleMessage((JSONObject) item);

                    System.out.println(message);
                });

        Feed feed = new Feed(new URL("https://cdn.discordapp.com/attachments/906109518142918688/916640084823011378/news.json"));
        feed.fetch();
        feed.buildFeed();



        /*
        JSONObject jsonMessages = new JSONObject(jsonContent);

        JSONArray messages = jsonMessages.getJSONArray("Messages");

        Feed feed = new Feed(jsonMessages);


        feed.printHashCodes();

        JsonMessageParser jsonMessageParserFromURL = new JsonMessageParser(new URL("https://cdn.discordapp.com/attachments/906109518142918688/916348549011218462/messages.json"));
        */


    }
}
