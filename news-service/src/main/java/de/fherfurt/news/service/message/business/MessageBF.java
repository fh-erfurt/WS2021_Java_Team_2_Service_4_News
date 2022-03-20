package de.fherfurt.news.service.message.business;

import de.fherfurt.news.service.message.entity.MessageRepository;
import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.news.service.message.entity.FileSystemRepository.FileTypes;

import de.fherfurt.news.service.core.persistence.errors.ConsumerWithException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

/**
 * This class represents the business facade of the massage class.
 * It is used to hide much of the complexity by decoupling the
 * client implementation from the complex subsystem.
 */

@Slf4j
@NoArgsConstructor(staticName = "of")
public class MessageBF {
    private final MessageRepository messageRepository = MessageRepository.of();
    private final FilesBF filesBF = FilesBF.of();

    /**
     * This method saves a given message to the message repository.
     * @param message
     */
    public void save(final Message message) {
        final boolean newMessage = message.getId() < 1;

        messageRepository.save(message);
    }

    /**
     * This function is used to find a message in the message repository by id.
     * @param id
     * @return optional Message
     */
    public Optional<Message> findBy(final int id) {
        return messageRepository.findBy(id);
    }

    /**
     * This method saves an image to the message repository.
     * @param image
     * @param content
     * @throws IOException
     */
    public void saveImage(final String path,  final byte[] content) throws IOException {
        filesBF.save(FileTypes.IMAGE, path, content, true);
    }

    /**
     * This function loads an image from the message repository.
     * @param imageId
     * @return optional array of bytes representing the image
     */
    public Optional<byte[]> loadImage(final String path) throws IOException {
        try {
            return filesBF.findBy(FileTypes.IMAGE, path);
        } catch (IOException e) {
            LOGGER.error("Could not find image for Path '" + path + "'", e);
            return Optional.empty();
        }
    }

    /**
     * This method deletes a message from the message repository.
     * @param id
     */
    public void delete(final int id){
        final Optional<Message> toDelete = findBy(id);

        if (toDelete.isEmpty()) {
            return;
        }

        if (toDelete.get().getImages() == null) {
            messageRepository.delete(toDelete.get());

            return;
        }

        toDelete.get()
                .getImages()
                .forEach(ConsumerWithException.wrap(image -> filesBF.delete(FileTypes.IMAGE, image)));

        messageRepository.delete(toDelete.get());
    }
}