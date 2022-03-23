package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.ImageDto;
import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.message.entity.Message;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(
        builder = @Builder(disableBuilder = true),
        mappingControl = DeepClone.class
)
public interface MessageMapper extends BeanMapper<Message, MessageDto> {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    default String mapImageDtoToString(ImageDto imageDto) {
        return imageDto.getPath();
    }

    default ImageDto mapStringToImageDto(String path) {
        return ImageDto.builder().withPath(path).build();
    }
}
