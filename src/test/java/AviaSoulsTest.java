import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Домодедово", "Пулково", 10_200, 10, 12);
    Ticket ticket2 = new Ticket("Сочи", "Звартноц", 4800, 8, 11);
    Ticket ticket3 = new Ticket("Внуково", "Аднан Мендерес", 20_000, 14, 19);
    Ticket ticket4 = new Ticket("Кеннеди", "Гатвик", 18_000, 18, 30);
    Ticket ticket5 = new Ticket("Кеннеди", "Абу-Даби", 33_000, 14, 26);
    Ticket ticket6 = new Ticket("Домодедово", "Пулково", 9_200, 1, 4);
    Ticket ticket7 = new Ticket("Домодедово", "Пулково", 15_200, 2, 3);
    Ticket ticket8 = new Ticket("Домодедово", "Пулково", 5_200, 11, 13);


    AviaSouls aviaSouls = new AviaSouls();

    @BeforeEach
    public void set() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
    }

    @Test
    public void shouldSortTicketsFromMinPrice() {
        Arrays.sort(aviaSouls.findAll());

        Ticket[] expected = {ticket2, ticket8, ticket6, ticket1, ticket7, ticket4, ticket3, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketsAndSortThemByPrice() {

        Ticket[] expected = {ticket8, ticket6, ticket1, ticket7};
        Ticket[] actual = aviaSouls.search("Домодедово", "Пулково");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByFightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(aviaSouls.findAll(), timeComparator);

        Ticket[] expected = {ticket7, ticket1, ticket8, ticket2, ticket6, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByFightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket1, ticket8, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Домодедово", "Пулково", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}