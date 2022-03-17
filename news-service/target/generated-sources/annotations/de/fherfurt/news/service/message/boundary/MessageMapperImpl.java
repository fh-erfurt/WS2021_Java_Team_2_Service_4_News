package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Image;
import de.fherfurt.news.service.message.entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T14:51:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MessageMapperImpl implements MessageMapper {

    private final ImageMapper imageMapper = Mappers.getMapper( ImageMapper.class );

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
        messageDto.setImages( imageListToImageDtoList( arg0.getImages() ) );
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
        message.setImages( imageDtoListToImageList( arg0.getImages() ) );
        message.setPublishedAt( arg0.getPublishedAt() );
        message.setContent( arg0.getContent() );
        message.setTopic( arg0.getTopic() );
        message.setFaculty( arg0.getFaculty() );
        message.setAppointmentName( arg0.getAppointmentName() );
        message.setAppointmentDateTime( arg0.getAppointmentDateTime() );

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
        message.setImages( imageListToImageList( arg0.getImages() ) );
        message.setPublishedAt( arg0.getPublishedAt() );
        message.setContent( arg0.getContent() );
        message.setTopic( arg0.getTopic() );
        message.setFaculty( arg0.getFaculty() );
        message.setAppointmentName( arg0.getAppointmentName() );
        message.setAppointmentDateTime( arg0.getAppointmentDateTime() );

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

    protected List<ImageDto> imageListToImageDtoList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDto> list1 = new ArrayList<ImageDto>( list.size() );
        for ( Image image : list ) {
            list1.add( imageMapper.toDto( image ) );
        }

        return list1;
    }

    protected List<Image> imageDtoListToImageList(List<ImageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( ImageDto imageDto : list ) {
            list1.add( imageMapper.fromDto( imageDto ) );
        }

        return list1;
    }

    protected List<Image> imageListToImageList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( Image image : list ) {
            list1.add( imageMapper.clone( image ) );
        }

        return list1;
    }

    protected List<ImageDto> imageDtoListToImageDtoList(List<ImageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageDto> list1 = new ArrayList<ImageDto>( list.size() );
        for ( ImageDto imageDto : list ) {
            list1.add( imageMapper.clone( imageDto ) );
        }

        return list1;
    }
}
