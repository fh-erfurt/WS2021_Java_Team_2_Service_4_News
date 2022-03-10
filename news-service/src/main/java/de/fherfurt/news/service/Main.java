package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.business.MessageBF;
import de.fherfurt.news.service.core.FileSystemRepository;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.UserPreferenceRepository;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.core.models.Image;
import de.fherfurt.news.service.core.models.Message;
import de.fherfurt.news.service.core.models.UserPreferences;

import javax.persistence.criteria.CriteriaQuery;
import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Deprecated
public class Main {
    public static void main(String[] args) throws IOException {
        MessageBF messageBF = MessageBF.of();
        Image image = new Image(1, "test.png");

        List<Image> images = new ArrayList<>();
        images.add(image);

        byte[] imageData = new byte[]{1, 5, 9, 6};

        Message message = Message.builder().withAuthor(1).withId(1).withContent("Hallo Lisa! :)").withImages(images).build();

        messageBF.save(message);
        messageBF.saveImage(image, imageData);
        messageBF.delete(1);
    }
}
