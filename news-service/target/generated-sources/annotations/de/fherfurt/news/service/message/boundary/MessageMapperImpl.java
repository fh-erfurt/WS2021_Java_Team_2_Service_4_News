package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T15:22:22+0200",
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
        messageDto.setTitle( entity.getTitle() );
        messageDto.setDescription( entity.getDescription() );
        messageDto.setUrl( entity.getUrl() );
        messageDto.setImages( stringListToImageDtoList( entity.getImages() ) );
        messageDto.setPublishedAt( entity.getPublishedAt() );
        messageDto.setContent( entity.getContent() );
        messageDto.setTopic( entity.getTopic() );
        messageDto.setFaculty( entity.getFaculty() );
        messageDto.setAppointmentName( entity.getAppointmentName() );
        messageDto.setAppointmentDateTime( entity.getAppointmentDateTime() );
        messageDto.setId( entity.getId() );

        return messageDto;
    }

    @Override
    public Message fromDto(MessageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setAuthor( dto.getAuthor() );
        message.setImages( imageDtoListToStringList( dto.getImages() ) );
        message.setTitle( dto.getTitle() );
        message.setDescription( dto.getDescription() );
        message.setUrl( dto.getUrl() );
        message.setPublishedAt( dto.getPublishedAt() );
        message.setContent( dto.getContent() );
        message.setTopic( dto.getTopic() );
        message.setAppointmentName( dto.getAppointmentName() );
        message.setAppointmentDateTime( dto.getAppointmentDateTime() );
        message.setFaculty( dto.getFaculty() );

        return message;
    }

    protected List<ImageDto> stringListToImageDtoList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDto> list1 = new ArrayList<ImageDto>( list.size() );
        for ( String string : list ) {
            list1.add( mapStringToImageDto( string ) );
        }

        return list1;
    }

    protected List<String> imageDtoListToStringList(List<ImageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( ImageDto imageDto : list ) {
            list1.add( mapImageDtoToString( imageDto ) );
        }

        return list1;
    }
}
