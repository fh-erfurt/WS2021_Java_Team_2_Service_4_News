package de.fherfurt.news.service;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.client.NewsClient;

import de.fherfurt.news.service.core.FilesystemRepository;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.UserPreferenceRepository;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.core.models.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
public class News implements NewsClient {
    private final MessageRepository messageRepository = MessageRepository.of();
    private final FilesystemRepository filesystemRepository = FilesystemRepository.of();
    private final UserPreferenceRepository userPreferenceRepository = UserPreferenceRepository.of();

    @Override
    public int save(MessageDto messageDto) {
        // TODO: handle the id

        Message message = BeanMapper.mapToEntity(messageDto);

        messageRepository.save(message);

        LOGGER.debug("Saved Message with id: " + message.getId());

        return message.getId();
    }

    // TODO: handle UserPrefs

    @Override
    public Optional<MessageDto> findBy(int id) {

        Optional<Message> message = messageRepository.findBy(id);

        return message.map(BeanMapper::mapToDto);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ImageDto> loadImagesBy(int ratingId) {
        return null;
    }

    @Override
    public List<MessageDto> findBy(Predicate<MessageDto> predicate) {
        return null;
    }

    public void saveAuthorToUserPreferences(Integer author, Integer userId) {

    }

    public void deleteAuthorFromUserPreferences(Integer author, Integer userId) {

    }
}
