package de.fherfurt.fetcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the basic Message.
 *
 * @author Benjamin Ehnes
 */
public class Message {
    /**
     * Represents the builder-class.
     *
     * Especially useful when creating objects with a lot of members.
     */
    public static class Builder {
        /**
         * Creates a basic instance with empty members.
         */
        public Builder() {
            this.authors = new ArrayList<String>();
        }

        /**
         * Initializes the authors using a list of strings.
         *
         * @param authors the authors being added
         * @return returns the instance with the added authors
         */
        public Builder withAuthors(List<String> authors) {
            this.authors.addAll(authors);

            return this;
        }

        /**
         * Initializes the author using a simple string.
         *
         * @param author the author being added
         * @return returns the instance with the added author
         */
        public Builder withAuthors(String author) {
            this.authors.add(author);

            return this;
        }

        /**
         * Creates an instance of the object
         *
         * @return Returns a new Message constructed from the fields specified.
         */
        public Message construct() {
            return new Message(this);
        }

        private ArrayList<String> authors = new ArrayList<String>();
    }

    private Message(Builder messageBuilder) {
        this.authors = messageBuilder.authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    private ArrayList<String> authors;
}
