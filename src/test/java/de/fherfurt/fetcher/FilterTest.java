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
       /*aapointmentName, publishedAt, AppointmentDateTime,Topic*/
/*
      void filterBy...(){
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_....json"); //Link überarbeiten
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();

          List<Message> filteredMessages = filter.filterBy...(messages, "...");

          Assertions.assertThat(filteredMessages)
                  .isNotEmpty()
                  .hasSize(...);

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertTrue(message.has...(""));
          }
      }


      @Test
      void ...() {
          Feed feed = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/927553911387213844/messages_....json");
          feed.fetch();

          Filter filter = new Filter();

          List<Message> messages = feed.getEntries();
           List<Message> filteredMessages = filter.filterBy...(messages, "...");


          Assertions.assertThat(filteredMessages)
          .isNotEmpty()
          .hasSize(...);

          for (Message message : filteredMessages) {
              org.junit.jupiter.api.Assertions.assertFalse(message.has...(""));
          }
      }
  }*/
