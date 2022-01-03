package de.fherfurt.fetcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;

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
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByDateAsc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageDateComparator());
    }

    @Test
    void sortByDateDesc() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByDateDesc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageDateComparator()));
    }

    @Test
    void sortByAppointmentAsc() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByAppointmentAsc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Comparator.nullsLast(new MessageAppointmentComparator()));
    }

    @Test
    void sortByAppointmentDesc() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByAppointmentDesc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(Comparator.nullsLast(new MessageAppointmentComparator())));
    }

    @Test
    void sortByAuthorAZ() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByAuthorAZ(given.getEntries(), given.getPersonService());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageAuthorComparator(given.getPersonService()));
    }

    @Test
    void sortByAuthorZA() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByAuthorZA(given.getEntries(), given.getPersonService());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageAuthorComparator(given.getPersonService())));
    }

    /**
    * author: Antonia Geschke
    * */

    @Test

    void sortByTopicAsc() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByTopicAsc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(new MessageTopicComparator());
    }

    @Test

    void sortByTopicDesc() {
        //given
        Feed given = new Feed("https://cdn.discordapp.com/attachments/906109518142918688/921751541982052352/messages2.json");
        given.fetch();
        Sort sort = new Sort();

        //when
        sort.sortByTopicDesc(given.getEntries());

        //then
        Assertions.assertThat(given.getEntries())
                .isNotEmpty()
                .hasSize(5)
                .doesNotHaveDuplicates()
                .isSortedAccordingTo(Collections.reverseOrder(new MessageTopicComparator()));
    }

}