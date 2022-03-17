package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.Database;
import de.fherfurt.news.service.core.persistence.Repository;

import java.util.Optional;

public class UserPreferenceRepository implements Repository<UserPreferences> {
    private final Database database = Database.newInstance();

    public static UserPreferenceRepository of() {
        return new UserPreferenceRepository();
    }

    @Override
    public void save(UserPreferences entity) {
        database.save(entity);
    }

    @Override
    public Optional<UserPreferences> findBy(int id) {
        return database.findBy(UserPreferences.class, id);
    }

    @Override
    public void delete(UserPreferences entity) {

    }
}
