package de.fherfurt.fetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Feed {
    List<Message> entries = new ArrayList<Message>();
    URL url = null;

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

        entries = JsonMessageParser.parseJsonFile(jsonObject);
    }

    public void buildFeed() {
        System.out.println(entries);
    }
}

