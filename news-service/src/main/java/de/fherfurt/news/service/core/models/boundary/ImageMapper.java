package de.fherfurt.news.service.core.models.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.core.models.Image;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

@Mapper(
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        mappingControl = DeepClone.class
)
public interface ImageMapper extends BeanMapper<Image, ImageDto> {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);
}
