package de.fherfurt.news.service.core.models.boundary;

import de.fherfurt.news.client.UserPreferencesDto;
import de.fherfurt.news.service.core.models.UserPreferences;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-27T11:00:11+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserPreferencesMapperImpl implements UserPreferencesMapper {

    @Override
    public UserPreferencesDto toDto(UserPreferences entity) {
        if ( entity == null ) {
            return null;
        }

        UserPreferencesDto userPreferencesDto = new UserPreferencesDto();

        userPreferencesDto.setId( entity.getId() );

        return userPreferencesDto;
    }

    @Override
    public UserPreferences fromDto(UserPreferencesDto dto) {
        if ( dto == null ) {
            return null;
        }

        int id = 0;

        id = dto.getId();

        UserPreferences userPreferences = new UserPreferences( id );

        return userPreferences;
    }

    @Override
    public UserPreferences clone(UserPreferences toClone) {
        if ( toClone == null ) {
            return null;
        }

        int id = 0;

        id = toClone.getId();

        UserPreferences userPreferences = new UserPreferences( id );

        return userPreferences;
    }

    @Override
    public UserPreferencesDto clone(UserPreferencesDto toClone) {
        if ( toClone == null ) {
            return null;
        }

        UserPreferencesDto userPreferencesDto = new UserPreferencesDto();

        userPreferencesDto.setId( toClone.getId() );
        List<Integer> list = toClone.getIgnoredAuthors();
        if ( list != null ) {
            userPreferencesDto.setIgnoredAuthors( new ArrayList<Integer>( list ) );
        }
        List<String> list1 = toClone.getPreferredFaculty();
        if ( list1 != null ) {
            userPreferencesDto.setPreferredFaculty( new ArrayList<String>( list1 ) );
        }
        userPreferencesDto.setSendPushMessages( toClone.isSendPushMessages() );

        return userPreferencesDto;
    }
}
