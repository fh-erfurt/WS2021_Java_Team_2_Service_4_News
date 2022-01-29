package de.fherfurt.news.client;


import lombok.*;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class UserPreferencesDto {
    int id;
    private HashSet<Integer> ignoredAuthors;
    private HashSet<String> preferredFaculty;
    private boolean sendPushMessages;
}
