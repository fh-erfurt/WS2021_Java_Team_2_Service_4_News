package de.fherfurt.news.service;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.boundary.MessageResource;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Main {
    public static void main(String[] args) throws Exception {
        /*
        MessageBF messageBF = MessageBF.of();

        Message message = Message.builder().withAuthor(1).withId(1).withContent("Hallo Lisa! :)").build();

        Image image = new Image(1, "test.png");
        byte[] imageData = new byte[]{1, 5, 9, 6};

        message.addImage(image);

        messageBF.save(message);
        messageBF.saveImage(image, imageData);
        messageBF.delete(1);
         */

        MessageResource messageResource = new MessageResource();

        ImageDto imageDtoFirst = new ImageDto(1, "image.png", new byte[]{0, 1, 2});
        ImageDto imageDtoSecond = new ImageDto(2, "image2.png", new byte[]{2, 1, 0});

        ArrayList<ImageDto> images = new ArrayList<>();
        images.add(imageDtoFirst);
        images.add(imageDtoSecond);

        MessageDto messageDto = MessageDto.builder().withAuthor(1).withContent("Hello :)").withImages(images).withId(3).build();

        // if we don´t set a Id, the program fails.

        int messageId = messageResource.save(messageDto);

        List<ImageDto> imagesFromResource = messageResource.loadImagesBy(messageId);

        messageResource.delete(messageId);
    }
}
