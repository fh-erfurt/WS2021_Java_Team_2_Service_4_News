package de.fherfurt.news.message.entity;

import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.news.service.message.entity.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Antonia Geschke
 * */
public class MessageRepositoryTest {
    @Test
    void validateFindByPredicate() {
        //GIVEN
        int messageId = 1;

        Message message = Message.builder().withAuthor(1).withId(messageId).withContent("Hallo!").build();

        MessageRepository objectUnderTest = MessageRepository.of();
        objectUnderTest.save(message);

        //WHEN
        List<Message> result = objectUnderTest.findBy(m -> m.getId() == messageId);

        //THEN
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.size()==1);
    }

    @Test
    void validateFindByTwoPredicates() {
        //GIVEN
        int messageId = 1;
        String content = "Hallo!";

        Message message = Message.builder().withAuthor(1).withId(messageId).withContent(content).build();

        MessageRepository objectUnderTest = MessageRepository.of();
        objectUnderTest.save(message);

        //WHEN
        List<Message> result = objectUnderTest.findBy(m -> m.getId() == messageId, m1 -> m1.getContent().equals(content));

        //THEN
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.size()==1);
    }

    @Test
    void invalidateFindByPredicates() {
        //GIVEN
        int messageId = 2;

        Message message = Message.builder().withAuthor(1).withId(1).withContent("Wilkommen an der FH").build();

        MessageRepository objectUnderTest = MessageRepository.of();
        objectUnderTest.save(message);

        //WHEN
        List<Message> result = objectUnderTest.findBy(m -> m.getId() == messageId);

        //THEN
        Assertions.assertTrue(result.isEmpty());

    }

    @Test
    void validateFindByPredicatesInTwoMessages() {
        //GIVEN
        int authorId = 1;

        Message message1 = Message.builder().withAuthor(authorId).withId(1).withContent("Wilkommen an der FH").build();
        Message message2 = Message.builder().withAuthor(authorId).withId(2).withContent("Wahlmodule fürs Sommersemester").build();

        MessageRepository objectUnderTest = MessageRepository.of();
        objectUnderTest.save(message1);
        objectUnderTest.save(message2);

        //WHEN
        List<Message> result = objectUnderTest.findBy(m -> m.getAuthor() == authorId);

        //THEN
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.size()==2);
    }
}