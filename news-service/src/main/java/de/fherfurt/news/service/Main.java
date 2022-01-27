package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.MessageRepository;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.core.models.Message;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

import javax.persistence.criteria.CriteriaBuilder;

@Deprecated
public class Main {
    public static void main(String[] args) throws IOException {
        MessageRepository messageRepository = MessageRepository.of();

        List<Message> messages = messageRepository.findBy(
                new FilterPredicateBuilder()
                        .withAuthor(1)
                        .withTopic("Java")
                        .withDateBefore(LocalDateTime.now())
                        .build());



        for (Message message : messages) {
            MessageDto messageDto = BeanMapper.mapToDto(message);

            System.out.println(messageDto);
        }
    }
}
