package de.fherfurt.news.service.message.business;

import de.fherfurt.news.service.core.persistence.Repository;
import de.fherfurt.news.service.core.persistence.errors.ConsumerWithException;
import de.fherfurt.news.service.message.entity.Image;
import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.news.service.message.entity.FileSystemRepository.FileTypes;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

import static de.fherfurt.news.service.core.persistence.errors.ConsumerWithException.wrap;

/**
 * This class represents the business facade of the massage class.
 * It is used to hide much of the complexity by decoupling the
 * client implementation from the complex subsystem.
 */

@Slf4j
@NoArgsConstructor(staticName = "of")
public class MessageBF {
    private final Repository<Message> messageRepository = new Repository<Message>(Message.class);
    private final Repository<Image> imageRepository = new Repository<Image>(Image.class);
    private final FilesBF filesBF = FilesBF.of();

    /**
     * This method saves a given message to the message repository.
     * @param message
     */
    public void save(final Message message) {
        if (!message.getImages().isEmpty()) {
            message.getImages().forEach(wrap(
                    image -> imageRepository.save(image)
            ));
        }

        messageRepository.save(message);
    }

    /**
     * This function is used to find a message in the message repository by id.
     * @param id
     * @return optional Message
     */
    public Optional<Message> findBy(final Long id) {
        return messageRepository.findBy(id);
    }

    /**
     * This method saves an image to the message repository.
     * @param path The specified path for the image.
     * @param content The actual content of the image. (most likely a byte representation)
     * @throws IOException
     */
    public void saveImage(final String path,  final byte[] content) throws IOException {
        filesBF.save(FileTypes.IMAGE, path, content, true);
    }

    /**
     * This function loads an image from the message repository.
     *
     * @param path the specified path of the image in our filesystem
     * @return optional array of bytes representing the content of the image
     * @throws IOException
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
    public void delete(final Long id) {
        final Optional<Message> toDelete = findBy(id);

        if (toDelete.isEmpty()) {
            return;
        }

        /*
        if (toDelete.get().getImages() == null) {
            messageRepository.delete(toDelete.get());

            return;
        }

        toDelete.get()
                .getImages()
                .forEach(ConsumerWithException.wrap(image -> filesBF.delete(FileTypes.IMAGE, image)));
        */
        messageRepository.delete(toDelete.get());
    }
}