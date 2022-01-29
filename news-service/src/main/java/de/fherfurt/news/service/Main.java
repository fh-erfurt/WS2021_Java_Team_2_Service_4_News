package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.UserPreferenceRepository;
import de.fherfurt.news.service.core.mappers.BeanMapper;
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
        News news = new News();

        news.save(MessageDto.builder().withId(3).withAuthor(1).build());
        news.save(MessageDto.builder().withId(4).withAuthor(1).build());

        Optional<MessageDto> message = news.findBy(1);
        Optional<MessageDto> message2 = news.findBy(34);

        UserPreferences userPreferences = new UserPreferences(1);

        HashSet<Integer> ignoredAuthors = new HashSet<Integer>();
        ignoredAuthors.add(1);
        ignoredAuthors.add(2);
        ignoredAuthors.add(3);

        userPreferences.setIgnoredAuthors(ignoredAuthors);

        UserPreferenceRepository userPreferenceRepository = UserPreferenceRepository.of();

        userPreferenceRepository.save(userPreferences);

        ignoredAuthors.add(4);

        userPreferences.setIgnoredAuthors(ignoredAuthors);

        Optional<UserPreferences> getUserPreferences = userPreferenceRepository.findBy(1);

        System.out.println(getUserPreferences.get());



        System.out.println(message);
        System.out.println(message2);
    }
}
