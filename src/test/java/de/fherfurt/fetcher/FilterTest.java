package de.fherfurt.fetcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class FilterTest {
    @Test
    void filterByAuthorTest() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByAuthor(messages, 1);

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(1);

        Message message = filteredMessages.get(0);

        org.junit.jupiter.api.Assertions.assertTrue(message.hasAuthor(1));
    }

    @Test
    void filterByBlacklistedAuthor() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByBlacklistedAuthor(messages, 1);

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(4);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasAuthor(1));
        }
    }

    /**
     * author: Lisa Sluka
     */

    @Test
    void filterByFaculty(){
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_fac.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByFaculty(messages, "Gebaeudetechnik_und_Informatik");

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(2);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasFaculty("Gebaeudetechnik_und_Informatik"));
        }


    }

    @Test
    void filterByFacultyAndGlobalNews(){
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_fac.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        List<Message> filteredMessages = filter.filterByFacultyAndGlobalNews(messages, "Gebaeudetechnik_und_Informatik");

        Assertions.assertThat(filteredMessages)
                .isNotEmpty()
                .hasSize(3);

        for (Message message : filteredMessages) {
            org.junit.jupiter.api.Assertions.assertTrue(message.hasFaculty("Gebaeudetechnik_und_Informatik") || message.hasFaculty("AllFaculties"));
        }
    }

    /**
     * author: Benjamin Ehnes
     */
    @Test
    void removeMessagesFromFaculty() {
        Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_fac.json");
        feed.fetch();

        Filter filter = new Filter();

        List<Message> messages = feed.getEntries();

        filter.removeMessagesFromFaculty(messages, "Gebaeudetechnik_und_Informatik");

        Assertions.assertThat(messages).isNotEmpty().hasSize(3);

        for (Message message : messages) {
            org.junit.jupiter.api.Assertions.assertFalse(message.hasFaculty("Gebaeudetechnik_und_Informatik"));
        }
    }
}


/* @Test code snippet
  /**
       * author: Celina Ludwigs
       */
       /*
       /*appointmentName, publishedAt, AppointmentDateTime,Topic*/
/*
      void filterByAppointmentName(){
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();

          List<Message> filteredMessages = filter.filterByAppointmentName(messages, "Helden basteln");

          Assertions.assertThat(filteredMessages)
                  .isNotEmpty()
                  .hasSize(1);

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertTrue(message.hasAppointmentName("Helden basteln"));
          }
      }


      @Test
      void filterByBlacklistedAppointmentName() {
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();
           List<Message> filteredMessages = filter.filterByBlacklistedAppointmentName(messages, "Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'");


          Assertions.assertThat(filteredMessages)
          .isNotEmpty()
          .hasSize(4); // oder 1,da andere messages ohne appointmentName

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertFalse(message.hasAppointmentName("Abschlussveranstaltung des Zertifikatskurses 'Gastechnik und Gasversorgung (FH)'"));
          }
      }
  }
-----------------------------------------------------------------------------------------------------------------------
 void filterByPublishedAt(){
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();

          List<Message> filteredMessages = filter.filterByPublishedAt(messages, "2021-12-08 09:30");

          Assertions.assertThat(filteredMessages)
                  .isNotEmpty()
                  .hasSize(1);

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertTrue(message.hasPublishedAt("2021-12-08 09:30"));
          }
      }


      @Test
      void filterByBlacklistedPublishedAt() {
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();
           List<Message> filteredMessages = filter.filterByBlacklistedPublishedAt(messages, "2021-10-02 17:42");


          Assertions.assertThat(filteredMessages)
          .isNotEmpty()
          .hasSize(4);

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertFalse(message.hasPublishedAt("2021-10-02 17:42"));
          }
      }
  }

  ---------------------------------------------------------------------------------------------------------------------
   void filterByAppointmentDateTime(){
            Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
            feed.fetch();

            Filter filter = new Filter();

            List<Message> messages = feed.getEntries();

            List<Message> filteredMessages = filter.filterByAppointmentDateTime(messages, "2021-12-12 14:00");

            Assertions.assertThat(filteredMessages)
                    .isNotEmpty()
                    .hasSize(1);

            for (Message message : filteredMessages) {
                org.junit.jupiter.api.Assertions.assertTrue(message.hasAppointmentDateTime("2021-12-12 14:00"));
            }
        }


        @Test
        void filterByBlacklistedAppointmentDateTime() {
            Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
            feed.fetch();

            Filter filter = new Filter();

            List<Message> messages = feed.getEntries();
             List<Message> filteredMessages = filter.filterByBlacklistedAppointmentDateTime(messages, "2021-11-25 17:00");


            Assertions.assertThat(filteredMessages)
            .isNotEmpty()
            .hasSize(4); //oder 1,da andere messages ohne appointmentDateTime

            for (Message message : filteredMessages) {
                org.junit.jupiter.api.Assertions.assertFalse(message.hasAppointmentDateTime("2021-11-25 17:00"));
            }
        }
    }

    -------------------------------------------------------------------------------------------------------------------
        void filterByTopic(){
                    Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
                    feed.fetch();

                    Filter filter = new Filter();

                    List<Message> messages = feed.getEntries();

                    List<Message> filteredMessages = filter.filterByTopic(messages, "Wissenschaft und Forschung");

                    Assertions.assertThat(filteredMessages)
                            .isNotEmpty()
                            .hasSize(2);

                    for (Message message : filteredMessages) {
                        org.junit.jupiter.api.Assertions.assertTrue(message.hasTopic("Wissenschaft und Forschung"));
                    }
                }


                @Test
                void filterByBlacklistedTopic() {
                    Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
                    feed.fetch();

                    Filter filter = new Filter();

                    List<Message> messages = feed.getEntries();
                     List<Message> filteredMessages = filter.filterByBlacklistedTopic(messages, "Architektur");


                    Assertions.assertThat(filteredMessages)
                    .isNotEmpty()
                    .hasSize(1);

                    for (Message message : filteredMessages) {
                        org.junit.jupiter.api.Assertions.assertFalse(message.hasTopic("Architektur"));
                    }
                }
            }