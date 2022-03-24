package de.fherfurt.news.client;

import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Predicate;

/**
 * This class represents the public API of the service.
 */
public interface NewsClient {
    /**
     * Saves a given message-data-transfer-object and persists the mapped entity in the database.
     *
     * @param messageDto The basic message object coming from the "outside".
     * @return Returns the id of the persisted entity.
     * @throws Exception This function might throw an exception.
     */
    public int save(MessageDto messageDto) throws Exception;
    
    /**
     * This method returns an optional of a message. If the database is able to find an entity matching the id, it will return it.
     *
     * @param messageId Value used to identify the message.
     * @return Optional of Message. If a message is found the optional contains a value.
     */
    public Optional<MessageDto> findBy(int messageId);

    /**
     * Deletes a given rating and it´s matching images
     *
     * @param id
     */
    public void delete(int id);

    /**
     * Load images matching a certain rating
     *
     * @param messageId a certain if of a message
     * @return returns a list of images
     */
    public List<ImageDto> loadImagesBy(int messageId);

    /**
     * Finds a list of messages using these conditions. If certain conditions are not given, they might be skipped.
     *
     * @param topic
     * @param university
     * @param faculty
     * @param fieldOfStudy
     * @return
     */
    public List<MessageDto> findBy(String topic, String university, String faculty, String fieldOfStudy);

    /**
     * Uses the appointment-service to create an appointment
     *
     * @param messageId
     */
    public boolean createAppointmentEntry(int messageId);

    // These might be implemented next semester.

    /*
    public void saveAuthorToUserPreferences(int author, int userId);

    public void deleteAuthorFromUserPreferences(int author, int userId);
     */
}
