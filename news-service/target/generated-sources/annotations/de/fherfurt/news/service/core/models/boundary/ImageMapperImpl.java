package de.fherfurt.news.service.core.models.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.service.core.models.Image;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-08T20:31:54+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDto toDto(Image entity) {
        if ( entity == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setId( entity.getId() );
        imageDto.setPath( entity.getPath() );

        return imageDto;
    }

    @Override
    public Image fromDto(ImageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( dto.getId() );
        image.setPath( dto.getPath() );

        return image;
    }

    @Override
    public Image clone(Image toClone) {
        if ( toClone == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( toClone.getId() );
        image.setPath( toClone.getPath() );

        return image;
    }

    @Override
    public ImageDto clone(ImageDto toClone) {
        if ( toClone == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setId( toClone.getId() );
        imageDto.setPath( toClone.getPath() );

        return imageDto;
    }
}
