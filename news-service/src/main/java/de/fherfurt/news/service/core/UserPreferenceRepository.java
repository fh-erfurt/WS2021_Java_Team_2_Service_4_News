package de.fherfurt.news.service.core;

import de.fherfurt.news.service.core.models.Message;
import de.fherfurt.news.service.core.models.UserPreferences;
import de.fherfurt.news.service.core.persistence.Database;
import de.fherfurt.news.service.core.persistence.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
