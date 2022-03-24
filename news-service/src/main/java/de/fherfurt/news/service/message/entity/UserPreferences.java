package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class was created in preparation for the next semester. It will be expanded in future...
 */

@Getter
@Setter
public class UserPreferences extends BaseBusinessEntity {
    private Set<Integer> ignoredAuthors;
    private Set<String> preferredFaculty;
    private boolean sendPushMessages;

    @Builder(setterPrefix = "with")
    public UserPreferences(int id) {
        super(id);
        this.ignoredAuthors = new HashSet<>();
        this.preferredFaculty = new HashSet<>();
        this.sendPushMessages = true;
    }

    @Override
    public String toString() {
        return "UserPreferences{" +
                "ignoredAuthors=" + ignoredAuthors +
                ", preferredFaculty=" + preferredFaculty +
                ", sendPushMessages=" + sendPushMessages +
                '}';
    }
}
