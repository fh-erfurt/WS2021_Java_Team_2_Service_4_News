package de.fherfurt.news.service;

import de.fherfurt.news.service.models.Message;

import de.fherfurt.persons.client.IPersonService;
import de.fherfurt.faculty.client.IFacultyService;

import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.faculty.client.DevFacultyService;

import de.fherfurt.appointment.client.IAppointmentService;
import de.fherfurt.appointment.client.DevAppointmentService;

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
import java.util.prefs.Preferences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Feed {
    private Preferences preferences;
    private List<Message> entries = new ArrayList<Message>();
    private URL url;
    private IPersonService personService;
    private IFacultyService facultyService;
    private IAppointmentService appointmentService;

    private static final Logger logger = LoggerFactory.getLogger("FeedLogger");

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

    public void buildFeed() {
        int index = 0;

        for (Message entry : entries) {
            logger.info("\n---------- Message " + index++ + " ----------");
            logger.info("Author: " + personService.getPersonFromId(entry.getAuthor()).getName());
            logger.info("Author-E-Mail: " + personService.getPersonFromId(entry.getAuthor()).getEmail());
            logger.info("Title: " + entry.getTitle());
            logger.info("Description: " + entry.getDescription());
            logger.info("URL: " + entry.getUrl());
            logger.info("ImageURL: " + entry.getUrlToImage());
            logger.info("Published at: " + entry.getPublishedAt());
            logger.info("Content: " + entry.getContent());
            logger.info("Topic: " + entry.getTopic());
            logger.info("Faculty: " + entry.getFaculty());
            logger.info("Faculty-Address: " + facultyService.getFacultyByName(entry.getFaculty()).getAddress());
            logger.info("Name of appointment: " + entry.getAppointmentName());
            logger.info("Date of appointment: " + entry.getAppointmentDateTime());
        }
    }

    public void addAppointments() {
        for (Message entry : entries) {
            if (entry.hasAppointmentAssociated()) {
                appointmentService.createAppointment(entry.getAppointmentName(), entry.getAppointmentDateTime());

                logger.info("Created an appointment!");
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

