package de.fherfurt.fetcher;

import java.util.ArrayList;
import java.util.List;

/**
 * authors: Lisa Sluka, Lucian Gerasch & Benjamin Ehnes
 */

public class Filter {
    public List<Message> filterByAuthor(List<Message> messages, int necessaryAuthor){
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(entry.hasAuthor(necessaryAuthor)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedAuthor(List<Message> messages, int blacklistedAuthor) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(!entry.hasAuthor(blacklistedAuthor)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByFacultyAndGlobalNews(List<Message> messages, String necessaryFaculty){
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty) || message.hasFaculty("AllFaculties")) {
                filteredMessages.add(message);
            }
        }

        return filteredMessages;
    }

    public List<Message> filterByFaculty(List<Message> messages, String necessaryFaculty){
        List<Message> filteredMessages = new ArrayList<Message>();

        for (Message message : messages) {
            if (message.hasFaculty(necessaryFaculty)) {
                filteredMessages.add(message);
            }
        }

        return filteredMessages;
    }

    public void removeMessagesFromFaculty(List<Message> messages, String blacklistedFaculty) {
        messages.removeIf(message -> message.hasFaculty(blacklistedFaculty));
    }
}
/*
*author:Celina Ludwigs
*/
/* public List<Message> filterByAuthor(List<Message> messages, int necessaryAppointmentName){
          List<Message> filteredMessages = new ArrayList<Message>();
          messages.forEach(entry->{
              if(entry.hasAppointmentName(necessaryAppointmentName)){
                  filteredMessages.add(entry);
              }
          });
          return filteredMessages;
      }

      public List<Message> filterByBlacklistedAppointmentName(List<Message> messages, int blacklistedAppointmentName) {
          List<Message> filteredMessages = new ArrayList<Message>();
          messages.forEach(entry->{
              if(!entry.hasAppointmentName(blacklistedAppointmentName)){
                  filteredMessages.add(entry);
              }
          });
          return filteredMessages;
      }
      -----------------------------------------------------------------------------------------------------------------
 public List<Message> filterByPublishedAt(List<Message> messages, int necessaryPublishedAt){
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(entry.hasPublishedAt(necessaryPublishedAt)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }

    public List<Message> filterByBlacklistedPublishedAt(List<Message> messages, int blacklistedPublishedAt) {
        List<Message> filteredMessages = new ArrayList<Message>();
        messages.forEach(entry->{
            if(!entry.hasPublishedAt(blacklistedPublishedAt)){
                filteredMessages.add(entry);
            }
        });
        return filteredMessages;
    }
    --------------------------------------------------------------------------------------------------------------------
     public List<Message> filterByAppointmentDateTime(List<Message> messages, int necessaryAppointmentDateTime){
            List<Message> filteredMessages = new ArrayList<Message>();
            messages.forEach(entry->{
                if(entry.hasAppointmentDateTime(necessaryAppointmentDateTime)){
                    filteredMessages.add(entry);
                }
            });
            return filteredMessages;
        }

        public List<Message> filterByBlacklistedAppointmentDateTime(List<Message> messages, int blacklistedAppointmentDateTime) {
            List<Message> filteredMessages = new ArrayList<Message>();
            messages.forEach(entry->{
                if(!entry.hasAppointmentDateTime(blacklistedAppointmentDateTime)){
                    filteredMessages.add(entry);
                }
            });
            return filteredMessages;
        }
        ---------------------------------------------------------------------------------------------------------------
         public List<Message> filterByTopic(List<Message> messages, int necessaryTopic){
                List<Message> filteredMessages = new ArrayList<Message>();
                messages.forEach(entry->{
                    if(entry.hasTopic(necessaryTopic)){
                        filteredMessages.add(entry);
                    }
                });
                return filteredMessages;
            }

            public List<Message> filterByBlacklistedAuthor(List<Message> messages, int blacklistedTopic) {
                List<Message> filteredMessages = new ArrayList<Message>();
                messages.forEach(entry->{
                    if(!entry.hasTopic(blacklistedTopic)){
                        filteredMessages.add(entry);
                    }
                });
                return filteredMessages;
            }*/