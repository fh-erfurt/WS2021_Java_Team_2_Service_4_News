package de.fherfurt.fetcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author: Lucian Gerasch
 * comment: All implemented tests are working and return the expected results.
 *
 */

class SortTest {
    @Test
    void sortByDateAsc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();

        //when
        sort.sortByDateAsc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageDateComparator());
    }

    @Test
    void sortByDateDesc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();

        Sort sort = new Sort();

        //when
        sort.sortByDateDesc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageDateComparator()));
    }

    @Test
    void sortByAppointmentAsc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();

        //when
        sort.sortByAppointmentAsc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Comparator.nullsLast(new MessageAppointmentComparator()));
    }

    @Test
    void sortByAppointmentDesc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();

        //when
        sort.sortByAppointmentDesc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(Comparator.nullsLast(new MessageAppointmentComparator())));
    }

    @Test
    void sortByAuthorAZ() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();
        DevPersonService devPersonService = new DevPersonService();

        //when
        sort.sortByAuthorAZ(messages, devPersonService);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageAuthorComparator(devPersonService));
    }

    @Test
    void sortByAuthorZA() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        DevPersonService devPersonService = new DevPersonService();
        Sort sort = new Sort();

        //when
        sort.sortByAuthorZA(messages, devPersonService);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageAuthorComparator(devPersonService)));
    }

    /**
    * author: Antonia Geschke
    * */

    @Test
    void sortByTopicAsc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();

        //when
        sort.sortByTopicAsc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageTopicComparator());
    }

    @Test

    void sortByTopicDesc() {
        //given
        List<Message> messages = TestResources.getTestMessageList();
        Sort sort = new Sort();

        //when
        sort.sortByTopicDesc(messages);

        //then
        Assertions.assertThat(messages)
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageTopicComparator()));
    }

}