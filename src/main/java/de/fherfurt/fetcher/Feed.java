package de.fherfurt.fetcher;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class Feed {
    private List<Message> entries = new ArrayList<Message>();
    private URL url;
    private IPersonService personService;
    private IFacultyService facultyService;
    private IAppointmentService appointmentService;

    public Feed(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            this.url = null;
        }

        this.personService = new DevPersonService();
        this.facultyService = new DevFacultyService();
        this.appointmentService = new DevAppointmentService();
    }

    public Feed(URL url, IPersonService personService, IFacultyService facultyService, IAppointmentService appointmentService) {
        this.url = url;
        this.personService = personService;
        this.facultyService = facultyService;
        this.appointmentService = appointmentService;
    }

    public Feed(URL url) {
        this.url = url;
        this.personService = new DevPersonService();
        this.facultyService = new DevFacultyService();
        this.appointmentService = new DevAppointmentService();
    }

    private String readContentFromURL(URL url) throws IOException {
        StringBuilder stringBuildeb = new StringBuilder();
        String line;

        InputStream in = url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                stringBuildeb.append(line).append(System.lineSeparator());
            }
        } finally {
            in.close();
        }

        return stringBuildeb.toString();
    }

    public void fetch() {
        if (this.url != null) {
            try {
                String content = readContentFromURL(url);

                JSONObject jsonObject = new JSONObject(content);

                this.entries = JsonMessageParser.parseJsonFile(jsonObject);
            } catch (JSONException | IOException exception) {
                // handle exception
            }
        }
    }


    /*
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

        List<Message> messages = JsonMessageParser.parseJsonFile(jsonObject);

        entries = JsonMessageParser.parseJsonFile(jsonObject);
    }
    */
    public void buildFeed() {
        int index = 0;
        for (Message entry : entries) {
            System.out.println("\n---------- Message " + index++ + " ----------");
            System.out.println("Author: " + personService.getPersonFromId(entry.getAuthor()).getName());
            System.out.println("Author-E-Mail: " + personService.getPersonFromId(entry.getAuthor()).getEmail());
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Description: " + entry.getDescription());
            System.out.println("URL: " + entry.getUrl());
            System.out.println("ImageURL: " + entry.getUrlToImage());
            System.out.println("Published at: " + entry.getPublishedAt());
            System.out.println("Content: " + entry.getContent());
            System.out.println("Topic: " + entry.getTopic());
            System.out.println("Faculty: " + entry.getFaculty());
            System.out.println("Faculty-Address: " + facultyService.getFacultyByName(entry.getFaculty()).getAddress());
            System.out.println("Name of appointment: " + entry.getAppointmentName());
            System.out.println("Date of appointment: " + entry.getAppointmentDateTime());
        }
    }

    public void addAppointments() {
        for (Message entry : entries) {
            if (entry.hasAppointmentAssociated()) {
                appointmentService.createAppointment(entry.getAppointmentName(), entry.getAppointmentDateTime());
            }
        }
    }

    public List<Message> getEntries() {
        return entries;
    }

    public void setEntries(List<Message> entries) {
        this.entries = entries;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public IPersonService getPersonService() {
        return personService;
    }
}

