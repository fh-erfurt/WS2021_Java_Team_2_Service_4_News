package de.fherfurt.news.service.core.models.boundary;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(
        builder = @Builder(disableBuilder = true),
        mappingControl = DeepClone.class
)
public interface UserPreferencesMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
}
