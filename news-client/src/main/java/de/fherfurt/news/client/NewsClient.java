package de.fherfurt.news.client;


import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Predicate;

public interface NewsClient {
    public int save(MessageDto messageDto);

    public Optional<MessageDto> findBy(int id);

    public void delete(int id);

    public List<ImageDto> loadImagesBy(int ratingId);

    public List<MessageDto> findBy(Predicate<MessageDto> predicate);
}
