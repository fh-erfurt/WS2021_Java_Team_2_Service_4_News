package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-20T12:44:24+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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

        message.setId( dto.getId() );
        message.setAuthor( dto.getAuthor() );
        message.setTitle( dto.getTitle() );
        message.setDescription( dto.getDescription() );
        message.setUrl( dto.getUrl() );
        message.setImages( imageDtoListToStringList( dto.getImages() ) );
        message.setPublishedAt( dto.getPublishedAt() );
        message.setContent( dto.getContent() );
        message.setTopic( dto.getTopic() );
        message.setFaculty( dto.getFaculty() );
        message.setAppointmentName( dto.getAppointmentName() );
        message.setAppointmentDateTime( dto.getAppointmentDateTime() );

        return message;
    }

    @Override
    public Message clone(Message toClone) {
        if ( toClone == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( toClone.getId() );
        message.setAuthor( toClone.getAuthor() );
        message.setTitle( toClone.getTitle() );
        message.setDescription( toClone.getDescription() );
        message.setUrl( toClone.getUrl() );
        List<String> list = toClone.getImages();
        if ( list != null ) {
            message.setImages( new ArrayList<String>( list ) );
        }
        message.setPublishedAt( toClone.getPublishedAt() );
        message.setContent( toClone.getContent() );
        message.setTopic( toClone.getTopic() );
        message.setFaculty( toClone.getFaculty() );
        message.setAppointmentName( toClone.getAppointmentName() );
        message.setAppointmentDateTime( toClone.getAppointmentDateTime() );

        return message;
    }

    @Override
    public MessageDto clone(MessageDto toClone) {
        if ( toClone == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthor( toClone.getAuthor() );
        messageDto.setTitle( toClone.getTitle() );
        messageDto.setDescription( toClone.getDescription() );
        messageDto.setUrl( toClone.getUrl() );
        messageDto.setImages( imageDtoListToImageDtoList( toClone.getImages() ) );
        messageDto.setPublishedAt( toClone.getPublishedAt() );
        messageDto.setContent( toClone.getContent() );
        messageDto.setTopic( toClone.getTopic() );
        messageDto.setFaculty( toClone.getFaculty() );
        messageDto.setAppointmentName( toClone.getAppointmentName() );
        messageDto.setAppointmentDateTime( toClone.getAppointmentDateTime() );
        messageDto.setId( toClone.getId() );

        return messageDto;
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

    protected ImageDto imageDtoToImageDto(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        ImageDto imageDto1 = new ImageDto();

        imageDto1.setPath( imageDto.getPath() );
        byte[] content = imageDto.getContent();
        if ( content != null ) {
            imageDto1.setContent( Arrays.copyOf( content, content.length ) );
        }

        return imageDto1;
    }

    protected List<ImageDto> imageDtoListToImageDtoList(List<ImageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDto> list1 = new ArrayList<ImageDto>( list.size() );
        for ( ImageDto imageDto : list ) {
            list1.add( imageDtoToImageDto( imageDto ) );
        }

        return list1;
    }
}
