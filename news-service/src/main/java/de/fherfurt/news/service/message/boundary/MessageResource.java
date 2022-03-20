package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.client.NewsClient;
import de.fherfurt.news.service.message.business.MessageBF;
import de.fherfurt.news.service.core.errors.FunctionWithException;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.client.transfer.objects.IPerson;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static de.fherfurt.news.service.core.persistence.errors.ConsumerWithException.wrap;

/**
 * This class implements the API of the news-service.
 *
 * It implements the main functionality.
 */
public class MessageResource implements NewsClient {
    private final MessageBF messageBF = MessageBF.of();

    private final PersonsClient personService = new DevPersonService();

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(MessageDto messageDto) throws Exception {
        final Message message = BeanMapper.mapToEntity(messageDto);
        //final Message message = new ModelMapper().map(messageDto, Message.class);

        final IPerson loaded = personService.findPersonUsingIteratorBy(message.getAuthor()).orElseThrow(() -> new Exception("Failed to find user!"));

        // save the message in the database
        messageBF.save(message);

        // for each image, save the image in the filesystem
        messageDto.getImages().forEach(wrap(
                image -> messageBF.saveImage(image.getPath(), image.getContent())
        ));

        return message.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<MessageDto> findBy(int messageId) {
        return messageBF.findBy(messageId).map(message -> (MessageDto) BeanMapper.mapToDto(message)).or(Optional::empty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {
        messageBF.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ImageDto> loadImagesBy(int messageId) {
        return messageBF.findBy(messageId)
                .map(message -> message.getImages().stream()
                        .map(FunctionWithException.wrap(
                                        imagePath -> ImageDto.builder()
                                                .withPath(imagePath)
                                                .withContent(messageBF.loadImage(imagePath).orElse(null))
                                                .build()
                                )
                        )
                        .collect(Collectors.toList())
                ).orElse(Collections.emptyList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MessageDto> findBy(Predicate<MessageDto> predicate) {
        return null;
    }

    @Override
    public void saveAuthorToUserPreferences(int author, int userId) {

    }

    @Override
    public void deleteAuthorFromUserPreferences(int author, int userId) {

    }
}
