package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.UserPreferencesDto;
import de.fherfurt.news.service.message.entity.UserPreferences;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T14:51:48+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class UserPreferencesMapperImpl implements UserPreferencesMapper {

    @Override
    public UserPreferencesDto toDto(UserPreferences entity) {
        if ( entity == null ) {
            return null;
        }

        UserPreferencesDto userPreferencesDto = new UserPreferencesDto();

        Set<Integer> set = entity.getIgnoredAuthors();
        if ( set != null ) {
            userPreferencesDto.setIgnoredAuthors( new HashSet<Integer>( set ) );
        }
        Set<String> set1 = entity.getPreferredFaculty();
        if ( set1 != null ) {
            userPreferencesDto.setPreferredFaculty( new HashSet<String>( set1 ) );
        }
        userPreferencesDto.setSendPushMessages( entity.isSendPushMessages() );

        return userPreferencesDto;
    }

    @Override
    public UserPreferences fromDto(UserPreferencesDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserPreferences userPreferences = new UserPreferences();

        HashSet<Integer> hashSet = dto.getIgnoredAuthors();
        if ( hashSet != null ) {
            userPreferences.setIgnoredAuthors( new HashSet<Integer>( hashSet ) );
        }
        HashSet<String> hashSet1 = dto.getPreferredFaculty();
        if ( hashSet1 != null ) {
            userPreferences.setPreferredFaculty( new HashSet<String>( hashSet1 ) );
        }
        userPreferences.setSendPushMessages( dto.isSendPushMessages() );

        return userPreferences;
    }
}
