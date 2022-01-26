package de.fherfurt.news.client;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class UserPreferencesDto {
    int id;
    private List<Integer> ignoredAuthors;
    private List<String> preferredFaculty;
}
