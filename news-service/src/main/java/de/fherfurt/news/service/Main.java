package de.fherfurt.news.service;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.boundary.MessageResource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Deprecated
public class Main {
    public static void main(String[] args) throws Exception {
        MessageResource messageResource = new MessageResource();

        ImageDto imageDtoFirst = new ImageDto("image.png", new byte[]{0, 1, 2});
        ImageDto imageDtoSecond = new ImageDto("image2.png", new byte[]{2, 1, 0});

        ArrayList<ImageDto> images = new ArrayList<>();
        images.add(imageDtoFirst);
        images.add(imageDtoSecond);

        MessageDto messageDto = MessageDto.builder()
                .withAuthor(1)
                .withContent("Hello :)")
                .withImages(images)
                .withId(3)
                .withAppointmentName("KI-Messe")
                .withAppointmentDateTime(LocalDateTime.now())
                .withTopic("KI-Messe")
                .withFaculty("Angewandte Informatik")
                .build();

        int messageId = messageResource.save(messageDto);

        List<MessageDto> messagesWithTopic = messageResource.findBy("KI-Messe", "", "Angewandte Informatik", "");

        System.out.println(messagesWithTopic.size());

        boolean createdAppointment = messageResource.createAppointmentEntry(3);

        System.out.println(createdAppointment);

        List<ImageDto> imagesFromResource = messageResource.loadImagesBy(messageId);

        for (ImageDto each : imagesFromResource) {
            System.out.print(each.getPath());
            System.out.println(Arrays.toString(each.getContent()));
        }

        messageResource.delete(messageId);
    }
}
