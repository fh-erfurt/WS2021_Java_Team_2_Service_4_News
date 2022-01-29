package de.fherfurt.news.service.core;

import de.fherfurt.news.service.core.models.Image;
import de.fherfurt.news.service.core.persistence.Repository;

import java.io.IOException;
import java.util.Optional;

public class FilesystemRepository {
    public static FilesystemRepository of() {

        return new FilesystemRepository();
    }


    public void save(Image image) throws IOException {

    }

    public Optional<Byte[]> findBy() {
        return Optional.empty();
    }

    public void delete(int id) {

    }
}
