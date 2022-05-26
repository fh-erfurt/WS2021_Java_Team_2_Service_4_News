package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Message;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T14:03:19+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageDto toDto(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthor( entity.getAuthor() );
        messageDto.setId( entity.getId() );

        return messageDto;
    }

    @Override
    public Message fromDto(MessageDto dto) {
        if ( dto == null ) {
            return null;
        }

        int author = 0;

        author = dto.getAuthor();

        Message message = new Message( author );

        message.setId( dto.getId() );

        return message;
    }
}
