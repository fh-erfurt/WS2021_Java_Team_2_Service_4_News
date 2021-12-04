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
