package de.fherfurt.news.service.core.models.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.models.Image;
import de.fherfurt.news.service.core.models.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-08T20:31:54+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MessageMapperImpl implements MessageMapper {

    private final ImageMapper imageMapper = Mappers.getMapper( ImageMapper.class );

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
        messageDto.setImages( imageListToImageDtoList( entity.getImages() ) );
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
        message.setImages( imageDtoListToImageList( dto.getImages() ) );
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
        message.setImages( imageListToImageList( toClone.getImages() ) );
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

        messageDto.setId( toClone.getId() );
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
