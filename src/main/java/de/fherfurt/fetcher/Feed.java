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

        JSONObject jsonObject = new JSONObject(content);

        JSONArray messages = jsonObject.getJSONArray("Messages");

        messages.forEach(item-> {
            Optional<Message> message = JsonMessageParser.parseSingleMessage((JSONObject) item);

            message.ifPresent(value -> entries.add(value));
        });

        System.out.println(entries.size());
    }

    public void buildFeed() {
        System.out.println(entries);
    }
}
