package de.fherfurt.news.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class ItemsController implements IController {
    private static final Database database = Database.instance();

    public ItemsController() {
        database.insert(Message.builder()
                .withAuthor(1)
                .withContent("Hello")
                .withPublishedAt(LocalDateTime.now())
                .build()
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getItems(Predicate<Message>... predicates) {
        return database.getItems(predicates);
    }

    public ActionResult updateItem(UUID uuid, Message message) {
        Optional<Message> existingMessage = database.getItem(uuid);

        if (!existingMessage.isPresent()) {
            return new ActionResult(ActionResult.StatusCode.ITEM_NOT_FOUND, null);
        }

        database.update(uuid, message);

        return new ActionResult(ActionResult.StatusCode.VALID_REQUEST, null);
    }
}
