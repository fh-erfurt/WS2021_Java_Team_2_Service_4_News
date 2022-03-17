package de.fherfurt.news.message.entity;

import de.fherfurt.news.service.message.business.MessageBF;
import de.fherfurt.news.service.message.entity.Image;
import de.fherfurt.news.service.message.entity.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

public class MessageBFTest {
    @Test
    void validateImageSaving() throws IOException {
        MessageBF messageBF = MessageBF.of();

        Message message = Message.builder().withAuthor(1).withId(1).withContent("Hallo! :)").build();

        Image image = new Image(1, "test.png");
        byte[] imageData = new byte[]{1, 5, 9, 6};

        message.addImage(image);

        messageBF.save(message);
        messageBF.saveImage(image, imageData);
        messageBF.delete(1);


    }

    @Test
    void validateMessageSavedAndDeletedWithNoImages() {
        //GIVEN
        int messageId = 1;

        MessageBF messageBF = MessageBF.of();

        Message message = Message.builder().withAuthor(1).withId(messageId).withContent("Hallo! :)").build();
        //WHEN
        messageBF.save(message);

        Optional<Message> messageFound = messageBF.findBy(messageId);

        //THEN
        Assertions.assertTrue(messageFound.isPresent());

        //WHEN
        messageBF.delete(message.getId());

        Optional<Message> messageNotFound = messageBF.findBy(messageId);

        //THEN
        Assertions.assertTrue(messageNotFound.isEmpty());
    }

    @Test
    void validateMessageSavedAndDeletedWithImages() throws IOException {
        // GIVEN
        int messageId = 1;
        int imageId = 1;

        MessageBF messageBF = MessageBF.of();

        Message message = Message.builder().withAuthor(1).withId(messageId).withContent("Hallo! :)").build();

        final Image image = Image.builder().withId(imageId).withPath("image.png").build();

        final byte[] content = new byte[] { 1, 2, 3 };

        // WHEN
        message.addImage(image);

        messageBF.save(message);

        messageBF.saveImage(image, content);

        messageBF.delete(messageId);

        // THEN
        Optional<byte[]> imageNotFound = messageBF.loadImage(imageId);

        Assertions.assertTrue(imageNotFound.isEmpty());
    }


}
