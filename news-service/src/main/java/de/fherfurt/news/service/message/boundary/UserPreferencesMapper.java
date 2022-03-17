package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.UserPreferencesDto;
import de.fherfurt.news.service.core.mappers.BeanMapper;
import de.fherfurt.news.service.message.entity.UserPreferences;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(
        builder = @Builder(disableBuilder = true),
        mappingControl = DeepClone.class
)
public interface UserPreferencesMapper extends BeanMapper<UserPreferences, UserPreferencesDto> {
    UserPreferencesMapper INSTANCE = Mappers.getMapper(UserPreferencesMapper.class);
}
