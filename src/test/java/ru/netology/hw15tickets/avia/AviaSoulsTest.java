package ru.netology.hw15tickets.avia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket(
            "Москва",
            "Хабаровск",
            20_300,
            8,
            16
    );
    Ticket ticket2 = new Ticket(
            "Москва",
            "Хабаровск",
            16_800,
            8,
            15
    );
    Ticket ticket3 = new Ticket(
            "Москва",
            "Благовещенск",
            19_100,
            11,
            19
    );
    Ticket ticket4 = new Ticket(
            "Москва",
            "Новосибирск",
            10_400,
            9,
            13
    );
    Ticket ticket5 = new Ticket(
            "Москва",
            "Хабаровск",
            16_800,
            10,
            20
    );
    Ticket ticket6 = new Ticket(
            "Москва",
            "Хабаровск",
            17_800,
            15,
            24
    );
    Ticket ticket7 = new Ticket(
            "Москва",
            "Хабаровск",
            18_600,
            15,
            24
    );

    AviaSouls souls = new AviaSouls();

    @BeforeEach
            void setUp() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
    }

    @Test
    public void shouldCompareToLess() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToMore() {

        int expected = -1;
        int actual = ticket4.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToEqual() {

        int expected = 0;
        int actual = ticket2.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {
        Ticket[] expected = { ticket4, ticket2, ticket5, ticket6, ticket7, ticket3, ticket1 };
        Ticket[] actual = { ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7 };
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTickets() {

        Ticket[] expected = { ticket2, ticket5, ticket6, ticket7, ticket1 };
        Ticket[] actual = souls.search("Москва", "Хабаровск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToLessTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToMoreTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = timeComparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToEqualTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = timeComparator.compare(ticket6, ticket7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = { ticket4, ticket2, ticket1, ticket3, ticket6, ticket7, ticket5 };
        Ticket[] actual = { ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7 };
        Arrays.sort(actual, timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = { ticket2, ticket1, ticket6, ticket7, ticket5 };
        Ticket[] actual = souls.searchAndSortBy("Москва", "Хабаровск", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
