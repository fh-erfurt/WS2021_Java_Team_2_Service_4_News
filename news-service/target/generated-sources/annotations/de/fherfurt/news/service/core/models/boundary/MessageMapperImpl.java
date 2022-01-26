package de.fherfurt.news.service.core.models.boundary;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.models.Message;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T16:08:41+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageDto toDto(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setId( entity.getId() );
        messageDto.setAuthor( entity.getAuthor() );
        messageDto.setTitle( entity.getTitle() );
        messageDto.setDescription( entity.getDescription() );
        messageDto.setUrl( entity.getUrl() );
        messageDto.setPublishedAt( entity.getPublishedAt() );
        messageDto.setContent( entity.getContent() );
        messageDto.setTopic( entity.getTopic() );
        messageDto.setFaculty( entity.getFaculty() );
        messageDto.setAppointmentName( entity.getAppointmentName() );
        messageDto.setAppointmentDateTime( entity.getAppointmentDateTime() );

        return messageDto;
    }

    @Override
    public Message fromDto(MessageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( dto.getId() );
        message.setAuthor( dto.getAuthor() );
        message.setTitle( dto.getTitle() );
        message.setDescription( dto.getDescription() );
        message.setUrl( dto.getUrl() );
        message.setPublishedAt( dto.getPublishedAt() );
        message.setContent( dto.getContent() );
        message.setTopic( dto.getTopic() );
        message.setFaculty( dto.getFaculty() );
        message.setAppointmentName( dto.getAppointmentName() );
        message.setAppointmentDateTime( dto.getAppointmentDateTime() );

        return message;
    }
}
