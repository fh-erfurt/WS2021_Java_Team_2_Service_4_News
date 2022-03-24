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
    date = "2022-03-24T15:34:41+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Homebrew)"
)
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageDto toDto(Message arg0) {
        if ( arg0 == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthor( arg0.getAuthor() );
        messageDto.setTitle( arg0.getTitle() );
        messageDto.setDescription( arg0.getDescription() );
        messageDto.setUrl( arg0.getUrl() );
        messageDto.setImages( stringListToImageDtoList( arg0.getImages() ) );
        messageDto.setPublishedAt( arg0.getPublishedAt() );
        messageDto.setContent( arg0.getContent() );
        messageDto.setTopic( arg0.getTopic() );
        messageDto.setFaculty( arg0.getFaculty() );
        messageDto.setAppointmentName( arg0.getAppointmentName() );
        messageDto.setAppointmentDateTime( arg0.getAppointmentDateTime() );
        messageDto.setId( arg0.getId() );

        return messageDto;
    }

    @Override
    public Message fromDto(MessageDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( arg0.getId() );
        message.setAuthor( arg0.getAuthor() );
        message.setTitle( arg0.getTitle() );
        message.setDescription( arg0.getDescription() );
        message.setUrl( arg0.getUrl() );
        message.setImages( imageDtoListToStringList( arg0.getImages() ) );
        message.setPublishedAt( arg0.getPublishedAt() );
        message.setContent( arg0.getContent() );
        message.setTopic( arg0.getTopic() );
        message.setAppointmentName( arg0.getAppointmentName() );
        message.setAppointmentDateTime( arg0.getAppointmentDateTime() );
        message.setFaculty( arg0.getFaculty() );

        return message;
    }

    @Override
    public Message clone(Message arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( arg0.getId() );
        message.setAuthor( arg0.getAuthor() );
        message.setTitle( arg0.getTitle() );
        message.setDescription( arg0.getDescription() );
        message.setUrl( arg0.getUrl() );
        List<String> list = arg0.getImages();
        if ( list != null ) {
            message.setImages( new ArrayList<String>( list ) );
        }
        message.setPublishedAt( arg0.getPublishedAt() );
        message.setContent( arg0.getContent() );
        message.setTopic( arg0.getTopic() );
        message.setAppointmentName( arg0.getAppointmentName() );
        message.setAppointmentDateTime( arg0.getAppointmentDateTime() );
        message.setFieldOfStudy( arg0.getFieldOfStudy() );
        message.setFaculty( arg0.getFaculty() );
        message.setUniversity( arg0.getUniversity() );

        return message;
    }

    @Override
    public MessageDto clone(MessageDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setAuthor( arg0.getAuthor() );
        messageDto.setTitle( arg0.getTitle() );
        messageDto.setDescription( arg0.getDescription() );
        messageDto.setUrl( arg0.getUrl() );
        messageDto.setImages( imageDtoListToImageDtoList( arg0.getImages() ) );
        messageDto.setPublishedAt( arg0.getPublishedAt() );
        messageDto.setContent( arg0.getContent() );
        messageDto.setTopic( arg0.getTopic() );
        messageDto.setFaculty( arg0.getFaculty() );
        messageDto.setAppointmentName( arg0.getAppointmentName() );
        messageDto.setAppointmentDateTime( arg0.getAppointmentDateTime() );
        messageDto.setId( arg0.getId() );

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
