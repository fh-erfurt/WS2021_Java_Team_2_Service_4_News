package de.fherfurt.news.client;

import de.fherfurt.news.client.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestResources {
    public static List<Message> getTestMessageList() {
        List<Message> messages = new ArrayList<Message>();

        messages.add(new Message(
                1,
                "Hitzerobuste Gemeinschaftsangebote am Erfurter Johannesplatz",
                "Ergebnisse der Bewohnerbefragung liegen vor",
                "https://www.fh-erfurt.de/news/detailansicht/hitzerobuste-gemeinschaftsangebote-am-erfurter-johannesplatz-ergebnisse-der-bewohnerbefragung-liegen-vor",
                "https://www.fh-erfurt.de/fileadmin/Bilder/_processed_/a/a/csm_066_ISP_HEATRESCITY__002__e2d510b9df.png",
                LocalDateTime.parse("2021-12-08 09:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                "Wissenschaft und Forschung",
                "Angewandte_Sozialwisschenschaft",
                null,
                null));

        messages.add(new Message(
                2,
                "Forschungsprojekt SMART MULTI-USE LOGISTIK mit Europäischem Transportpreis für Nachhaltigkeit ausgezeichnet",
                "Als einer von zehn Projektpartnern erforscht die FHE die Erfassung und Prognose der CO2-Emissionen.",
                "https://www.fh-erfurt.de/news/detailansicht/forschungsprojekt-smart-multi-use-logistik-mit-europaeischem-transportpreis-fuer-nachhaltigkeit-ausgezeichnet",
                "https://www.fh-erfurt.de/fileadmin/Bilder/_processed_/1/9/csm_preview_COLOURBOX33720923_Pakate__003__62a64b4c7f.jpg",
                LocalDateTime.parse("2021-11-06 13:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                "Wissenschaft und Forschung",
                "AllFaculties",
                null,
                null));

        messages.add(new Message(
                3,
                "Erfolgreicher Abschluss im Zertifikatskurs 'Gastechnik und Gasversorgung (FH)'",
                "Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'",
                "https://www.fh-erfurt.de/news/detailansicht/erfolgreicher-abschluss-im-zertifikatskurs-gastechnik-und-gasversorgung-fh",
                "https://www.fh-erfurt.de/fileadmin/Bilder/_processed_/6/e/csm_gastechnik_und_gasversorgung_30313d6ece.jpg",
                LocalDateTime.parse("2021-10-02 17:42", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                "Veranstaltungen",
                "Gebaeudetechnik_und_Informatik",
                "Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'",
                LocalDateTime.parse("2021-11-25 17:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));

        messages.add(new Message(
                4,
                "Helden basteln mit der Fachhochschule Erfurt",
                "Die FH Erfurt beim Festival für Geist, Demokratie und Geschichte.",
                "https://www.fh-erfurt.de/news/detailansicht/helden-basteln-mit-der-fachhochschule-erfurt",
                "https://www.fh-erfurt.de/fileadmin/Bilder/_processed_/7/d/csm_Helden_lernlab_171c95f29a.jpg",
                LocalDateTime.parse("2021-11-30 15:26", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                "Bildung und Erziehung von Kindern",
                "Wirtschaft_Logistik_Verkehr",
                "Helden basteln",
                LocalDateTime.parse("2021-12-12 14:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));

        messages.add(new Message(
                5,
                "Leuchtobjekte in der Erfurter Innenstadt",
                "Der Rundgang, der um 17:30 Uhr an der Krämerbrücke startete sorgte für große Aufmerksamkeit",
                "https://www.fh-erfurt.de/news/detailansicht/leuchtobjekte-in-der-erfurter-innenstadt",
                "https://www.fh-erfurt.de/fileadmin/Bilder/_processed_/e/a/csm_7e835554eb_84460ae183.jpg",
                LocalDateTime.parse("2021-11-17 22:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                "Architektur",
                "Gebaeudetechnik_und_Informatik",
                null,
                null));

        return messages;
    }
}
