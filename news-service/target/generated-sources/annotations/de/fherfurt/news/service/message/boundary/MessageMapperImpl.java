package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Image;
import de.fherfurt.news.service.message.entity.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T15:45:28+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
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
        messageDto.setImages( imageCollectionToImageDtoList( arg0.getImages() ) );
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

        message.setAuthor( arg0.getAuthor() );
        message.setImages( imageDtoListToImageCollection( arg0.getImages() ) );
        message.setTitle( arg0.getTitle() );
        message.setDescription( arg0.getDescription() );
        message.setUrl( arg0.getUrl() );
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

        message.setVersion( arg0.getVersion() );
        message.setCreated( arg0.getCreated() );
        message.setModified( arg0.getModified() );
        message.setAuthor( arg0.getAuthor() );
        message.setImages( imageCollectionToImageCollection( arg0.getImages() ) );
        message.setTitle( arg0.getTitle() );
        message.setDescription( arg0.getDescription() );
        message.setUrl( arg0.getUrl() );
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

    protected List<ImageDto> imageCollectionToImageDtoList(Collection<Image> collection) {
        if ( collection == null ) {
            return null;
        }

        List<ImageDto> list = new ArrayList<ImageDto>( collection.size() );
        for ( Image image : collection ) {
            list.add( mapStringToImageDto( image ) );
        }

        return list;
    }

    protected Collection<Image> imageDtoListToImageCollection(List<ImageDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<Image> collection = new ArrayList<Image>( list.size() );
        for ( ImageDto imageDto : list ) {
            collection.add( mapImageDtoToString( imageDto ) );
        }

        return collection;
    }

    protected Image imageToImage(Image image) {
        if ( image == null ) {
            return null;
        }

        Image image1 = new Image();

        image1.setVersion( image.getVersion() );
        image1.setCreated( image.getCreated() );
        image1.setModified( image.getModified() );

        return image1;
    }

    protected Collection<Image> imageCollectionToImageCollection(Collection<Image> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<Image> collection1 = new ArrayList<Image>( collection.size() );
        for ( Image image : collection ) {
            collection1.add( imageToImage( image ) );
        }

        return collection1;
    }

    protected ImageDto imageDtoToImageDto(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        ImageDto imageDto1 = new ImageDto();

        imageDto1.setFilePath( imageDto.getFilePath() );
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
