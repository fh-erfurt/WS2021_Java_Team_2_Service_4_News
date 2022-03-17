package de.fherfurt.news.message.entity;

import de.fherfurt.news.service.message.entity.Image;
import org.junit.jupiter.api.Test;

public class MessageRepositoryTest {
    //findimageby 2 errors

    @Test
    void validateFindImageById() {
        //GIVEN
        Image image = new Image(1, "test.png");
        byte[] imageData = new byte[]{1, 5, 9, 6};

        //WHEN



        //THEN
    }

    @Test
    void validateFindByPredicate() {
        //GIVEN
        int messageId = 1;

        //WHEN

        //THEN

    }
}