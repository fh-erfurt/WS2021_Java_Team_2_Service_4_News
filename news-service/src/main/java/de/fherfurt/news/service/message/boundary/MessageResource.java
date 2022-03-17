package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.client.NewsClient;
import de.fherfurt.news.service.message.business.MessageBF;
import de.fherfurt.news.service.core.errors.FunctionWithException;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.message.entity.Message;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static de.fherfurt.news.service.core.persistence.errors.ConsumerWithException.wrap;

public class MessageResource implements NewsClient {
    private final MessageBF messageBF = MessageBF.of();

    @Override
    public int save(MessageDto messageDto) throws Exception {
        final Message message = BeanMapper.mapToEntity(messageDto);

        messageBF.save(message);

        messageDto.getImages().forEach(wrap(
                image -> messageBF.saveImage(message.getImages().get(messageDto.getImages().indexOf(image)), image.getContent())
        ));

        return message.getId();
    }

    @Override
    public Optional<MessageDto> findBy(int messageId) {
        return messageBF.findBy(messageId).map(message -> (MessageDto) BeanMapper.mapToDto(message)).or(Optional::empty);
    }

    @Override
    public void delete(int id) {
        messageBF.delete(id);
    }

    @Override
    public List<ImageDto> loadImagesBy(int messageId) {
        return messageBF.findBy(messageId)
                .map(message -> message.getImages().stream()
                        .map(FunctionWithException.wrap(
                                        image -> ImageDto.builder()
                                                .withId(image.getId())
                                                .withPath(image.getPath())
                                                .withContent(messageBF.loadImage(image.getId()).orElse(null))
                                                .build()
                                )
                        )
                        .collect(Collectors.toList())
                ).orElse(Collections.emptyList());
    }

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
