package de.fherfurt.news.service.message.boundary;

import de.fherfurt.appointment.client.DevAppointmentService;
import de.fherfurt.appointment.client.IAppointmentService;
import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.client.NewsClient;
import de.fherfurt.news.service.message.business.MessageBF;
import de.fherfurt.news.service.core.errors.FunctionWithException;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.persons.client.DevPersonService;
import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.client.transfer.objects.IPerson;
import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Model;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static de.fherfurt.news.service.core.persistence.errors.ConsumerWithException.wrap;

/**
 * This class implements the API of the news-service.
 *
 * It implements the main functionality.
 */
public class MessageResource implements NewsClient {
    private final ModelMapper modelMapper = new ModelMapper();
    private final MessageBF messageBF = MessageBF.of();

    private final PersonsClient personService = new DevPersonService();

    private final IAppointmentService appointmentService = new DevAppointmentService();

    /**
     * {@inheritDoc}
     */
    @Override
    public Long save(MessageDto messageDto) throws Exception {

        final Message message = modelMapper.map(messageDto, Message.class);

        //final Message message = BeanMapper.mapToEntity(messageDto);
        //final Message message = new ModelMapper().map(messageDto, Message.class);

        Optional<IPerson> person = personService.findPersonUsingIteratorBy(message.getAuthor());

        if (person.isEmpty()) {
            return 0L;
        }

        // save the message in the database
        messageBF.save(message);

        /*
        if (message.getImages() != null) {
            // for each image, save the image in the filesystem
            messageDto.getImages().forEach(wrap(
                    image -> messageBF.saveImage(image.getPath(), image.getContent())
            ));
        }
         */

        return 0L;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<MessageDto> findBy(Long messageId) {
        return messageBF.findBy(messageId).map(message -> (MessageDto) modelMapper.map(message, MessageDto.class)).or(Optional::empty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {
        // messageBF.delete(id);
    }

    /**
     * {@inheritDoc}
     */
        @Override

    public List<ImageDto> loadImagesBy(int messageId) {
            /*
        return messageBF.findBy(messageId)
                .map(message -> message.getImages().stream()
                        .map(FunctionWithException.wrap(
                                        imagePath -> ImageDto.builder()
                                                .withPath(imagePath)
                                                .withContent(messageBF.loadImage(imagePath).orElse(null))
                                                .build()
                                )
                        )
                        .collect(Collectors.toList())
                ).orElse(Collections.emptyList());
                */
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MessageDto> findBy(String topic, String university, String faculty, String fieldOfStudy) {
        List<Predicate<Message>> predicates = new ArrayList<>();

        /*
        if (university != null && !university.isBlank()) {
            predicates.add(message -> message.getUniversity().equals(university));
        }

        if (faculty != null && !faculty.isBlank()) {
            predicates.add(message -> message.getFaculty().equals(faculty));
        }

        if (fieldOfStudy != null && !fieldOfStudy.isBlank()) {
            predicates.add(message -> message.getFieldOfStudy().equals(fieldOfStudy));
        }

        if (topic != null && !topic.isBlank()) {
            predicates.add(message -> message.getTopic().equals(topic));
        }
        */

        return new ArrayList<>(); //messageBF.findBy(predicates.stream().reduce(x -> true, Predicate::and)).stream().map(message -> (MessageDto) modelMapper.map(message, MessageDto.class)).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createAppointmentEntry(int messageId) {
        /*

        Optional<Message> message = messageBF.findBy(messageId);

        if (message.isEmpty()) {
            return false;
        }
        if (message.get().getAppointmentName() != null && message.get().getAppointmentDateTime() != null) {
            appointmentService.createAppointment(message.get().getAppointmentName(), message.get().getAppointmentDateTime());

            return true;
        }
         */

        return false;
    }

    // These might be implemented next semester.

    /*
    @Override
    public void saveAuthorToUserPreferences(int author, int userId) {

    }

    @Override
    public void deleteAuthorFromUserPreferences(int author, int userId) {

    }
     */
}
