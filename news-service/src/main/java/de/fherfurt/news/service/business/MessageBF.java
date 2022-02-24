package de.fherfurt.news.service.business;

import de.fherfurt.news.service.core.FileSystemRepository;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.models.Image;
import de.fherfurt.news.service.core.models.Message;
import de.fherfurt.news.service.core.FileSystemRepository.FileTypes;

import de.fherfurt.news.service.core.persistence.errors.ConsumerWithException;
import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.persons.client.IPersonService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(staticName = "of")
public class MessageBF {
    private final MessageRepository messageRepository = MessageRepository.of();
    private final FilesBF filesBF = FilesBF.of();

    private IPersonService personService = new DevPersonService();

    // TODO: Evaluator???
    public void save(final Message message) {
        final boolean newMessage = message.getId() < 1;



        messageRepository.save(message);
    }

    public Optional<Message> findBy(final int id) {
        return messageRepository.findBy(id);
    }

    public void saveImage(final Image image, byte[] content) throws IOException {
        final boolean isNewImage = image.getId() < 1;

        filesBF.save(FileTypes.IMAGE, image.getPath(), content, isNewImage);
    }

    public Optional<byte[]> loadImage(final int imageId) {
        final Image image = messageRepository.findImageBy(imageId);

        try {
            return filesBF.findBy(FileTypes.IMAGE, image.getPath());
        } catch (IOException e) {
            LOGGER.error("Could not find image for ID '" + imageId + "'", e);
            return Optional.empty();
        }
    }

    public void delete(final int id){
        final Optional<Message> toDelete = findBy(id);
        if (toDelete.isEmpty()) {
            return;
        }

        toDelete.get()
                .getImages()
                .forEach(ConsumerWithException.wrap(image -> filesBF.delete(FileTypes.IMAGE, image.getPath())));

        messageRepository.delete(toDelete.get());
    }
}