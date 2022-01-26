package de.fherfurt.news.service.core.models;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class UserPreferences extends BaseBusinessEntity {
    private List<Integer> ignoredAuthors;
    private List<String> preferredFaculty;
    private boolean sendPushMessages;
    // ignorierte Themen
    // Semester

    @Builder(setterPrefix = "with")
    public UserPreferences(int id) {
        super(id);
        this.ignoredAuthors = new ArrayList<>();
        this.preferredFaculty = new ArrayList<>();
        this.sendPushMessages = true;
    }
}
