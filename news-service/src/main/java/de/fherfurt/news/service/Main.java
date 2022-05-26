package de.fherfurt.news.service;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.persistence.Repository;
import de.fherfurt.news.service.message.entity.Message;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import java.util.Optional;

@Deprecated
public class Main {
    public static void main(String[] args) throws Exception {
        EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();

        Message message = new Message(1);
        Repository<Message> messageRepository = new Repository<Message>(Message.class);
        messageRepository.save(message);

        Optional<Message> messageFound = messageRepository.findBy(1L);

        ModelMapper modelMapper = new ModelMapper();

        MessageDto messageDto = modelMapper.map(messageFound.get(), MessageDto.class);

        System.out.println(messageDto.toString());

        JPA.shutdown();

        /*
        ImageDto imageDtoFirst = new ImageDto("image.png", new byte[]{0, 1, 2});
        ImageDto imageDtoSecond = new ImageDto("image2.png", new byte[]{2, 1, 0});

        ArrayList<ImageDto> images = new ArrayList<>();
        images.add(imageDtoFirst);
        images.add(imageDtoSecond);
         */

        /*
        Message message = Message.builder()
                .withAuthor(1)
                .withContent("Hello :)")
                .withAppointmentName("KI-Messe")
                .withAppointmentDateTime(LocalDateTime.now())
                .withTopic("KI-Messe")
                .withFaculty("Angewandte Informatik")
                .build();
        */



        // Long messageId = messageResource.save(messageDto);

        // List<MessageDto> messagesWithTopic = messageResource.findBy("KI-Messe", "", "Angewandte Informatik", "");

        // System.out.println(messagesWithTopic.size());

        // boolean createdAppointment = messageResource.createAppointmentEntry(3);

        // System.out.println(createdAppointment);

        /*
        List<ImageDto> imagesFromResource = messageResource.loadImagesBy(messageId);

        for (ImageDto each : imagesFromResource) {
            System.out.print(each.getPath());
            System.out.println(Arrays.toString(each.getContent()));
        }

        messageResource.delete(messageId);
        */
    }
}
