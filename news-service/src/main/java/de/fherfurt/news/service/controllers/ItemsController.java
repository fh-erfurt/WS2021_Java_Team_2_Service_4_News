package de.fherfurt.news.service.controllers;

import de.fherfurt.news.service.ActionResult;
import de.fherfurt.news.service.controllers.IController;
import de.fherfurt.news.service.persistence.Database;
import de.fherfurt.news.service.models.Message;

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

        database.insert(Message.builder()
                .withAuthor(2)
                .withContent("Hello")
                .withPublishedAt(LocalDateTime.now())
                .build()
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getItems(Integer amount, Predicate<Message>... predicates) {
        return database.getItems(amount, predicates);
    }

    @Override
    public void insert(Message message) {
        database.insert(message);
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
