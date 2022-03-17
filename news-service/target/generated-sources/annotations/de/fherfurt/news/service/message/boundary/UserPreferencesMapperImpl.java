package de.fherfurt.news.service.message.boundary;

import de.fherfurt.news.client.UserPreferencesDto;
import de.fherfurt.news.service.message.entity.UserPreferences;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T14:51:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserPreferencesMapperImpl implements UserPreferencesMapper {

    @Override
    public UserPreferencesDto toDto(UserPreferences arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserPreferencesDto userPreferencesDto = new UserPreferencesDto();

        userPreferencesDto.setId( arg0.getId() );
        Set<Integer> set = arg0.getIgnoredAuthors();
        if ( set != null ) {
            userPreferencesDto.setIgnoredAuthors( new HashSet<Integer>( set ) );
        }
        Set<String> set1 = arg0.getPreferredFaculty();
        if ( set1 != null ) {
            userPreferencesDto.setPreferredFaculty( new HashSet<String>( set1 ) );
        }
        userPreferencesDto.setSendPushMessages( arg0.isSendPushMessages() );

        return userPreferencesDto;
    }

    @Override
    public UserPreferences fromDto(UserPreferencesDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        int id = 0;

        id = arg0.getId();

        UserPreferences userPreferences = new UserPreferences( id );

        HashSet<Integer> hashSet = arg0.getIgnoredAuthors();
        if ( hashSet != null ) {
            userPreferences.setIgnoredAuthors( new HashSet<Integer>( hashSet ) );
        }
        HashSet<String> hashSet1 = arg0.getPreferredFaculty();
        if ( hashSet1 != null ) {
            userPreferences.setPreferredFaculty( new HashSet<String>( hashSet1 ) );
        }
        userPreferences.setSendPushMessages( arg0.isSendPushMessages() );

        return userPreferences;
    }

    @Override
    public UserPreferences clone(UserPreferences arg0) {
        if ( arg0 == null ) {
            return null;
        }

        int id = 0;

        id = arg0.getId();

        UserPreferences userPreferences = new UserPreferences( id );

        Set<Integer> set = arg0.getIgnoredAuthors();
        if ( set != null ) {
            userPreferences.setIgnoredAuthors( new HashSet<Integer>( set ) );
        }
        Set<String> set1 = arg0.getPreferredFaculty();
        if ( set1 != null ) {
            userPreferences.setPreferredFaculty( new HashSet<String>( set1 ) );
        }
        userPreferences.setSendPushMessages( arg0.isSendPushMessages() );

        return userPreferences;
    }

    @Override
    public UserPreferencesDto clone(UserPreferencesDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserPreferencesDto userPreferencesDto = new UserPreferencesDto();

        userPreferencesDto.setId( arg0.getId() );
        HashSet<Integer> hashSet = arg0.getIgnoredAuthors();
        if ( hashSet != null ) {
            userPreferencesDto.setIgnoredAuthors( new HashSet<Integer>( hashSet ) );
        }
        HashSet<String> hashSet1 = arg0.getPreferredFaculty();
        if ( hashSet1 != null ) {
            userPreferencesDto.setPreferredFaculty( new HashSet<String>( hashSet1 ) );
        }
        userPreferencesDto.setSendPushMessages( arg0.isSendPushMessages() );

        return userPreferencesDto;
    }
}
