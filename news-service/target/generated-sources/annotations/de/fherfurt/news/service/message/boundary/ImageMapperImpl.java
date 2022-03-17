package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.service.message.entity.Image;
import java.util.Arrays;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T14:51:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDto toDto(Image arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setId( arg0.getId() );
        imageDto.setPath( arg0.getPath() );

        return imageDto;
    }

    @Override
    public Image fromDto(ImageDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( arg0.getId() );
        image.setPath( arg0.getPath() );

        return image;
    }

    @Override
    public Image clone(Image arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( arg0.getId() );
        image.setPath( arg0.getPath() );

        return image;
    }

    @Override
    public ImageDto clone(ImageDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setId( arg0.getId() );
        imageDto.setPath( arg0.getPath() );
        byte[] content = arg0.getContent();
        if ( content != null ) {
            imageDto.setContent( Arrays.copyOf( content, content.length ) );
        }

        return imageDto;
    }
}
