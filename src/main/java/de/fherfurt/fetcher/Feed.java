package de.fherfurt.fetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.sound.midi.SysexMessage;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class Feed {
    final List<Message> entries = new ArrayList<Message>();

    public Feed(URL url) {
        
    }

    public Feed(JSONObject jsonObject) {
        if (jsonObject.has("Messages")) {
            JSONArray messages = jsonObject.getJSONArray("Messages");

            messages.forEach(item -> {
                JsonMessageParser jsonMessageParser = new JsonMessageParser((JSONObject) item);

                Message message = jsonMessageParser.constructMessage();

                entries.add(message);
            });
        } else {
            System.out.println("Could not parse Messages!");
        }
    }

    public void print() {
        entries.forEach(item -> {
            System.out.println(item);
        });
    }

    public void printHashCodes() {
        entries.forEach(item -> {
            System.out.println(item.hashCode());
        });
    }
}
