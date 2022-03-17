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
     *
     *
     * @param id
     */
    public void delete(int id);

    /**
     *
     *
     * @param ratingId
     * @return
     */
    public List<ImageDto> loadImagesBy(int ratingId);

    public List<MessageDto> findBy(Predicate<MessageDto> predicate);

    public void saveAuthorToUserPreferences(int author, int userId);

    public void deleteAuthorFromUserPreferences(int author, int userId);
}
