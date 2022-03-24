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
 *
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
     * @param ratingId
     * @return returns a list of images
     */
    public List<ImageDto> loadImagesBy(int ratingId);

    /**
     * Returns a list of message, matching the given faculty
     *
     * After talking to the faculty-team, we got assured every faculty would be unambiguous.
     *
     * @param facultyName Name of the faculty
     * @return returns a list of messages
     */
    public List<MessageDto> findBy(String facultyName);

    /**
     * Uses the appointment-service to create an appointment
     *
     * @param messageId
     */
    public boolean createAppointmentEntry(int messageId);

    /*
    public void saveAuthorToUserPreferences(int author, int userId);

    public void deleteAuthorFromUserPreferences(int author, int userId);
     */
}
