import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Домодедово", "Пулково", 10_200, 18, 20);
    Ticket ticket2 = new Ticket("Сочи", "Звартноц", 4800, 8, 11);
    Ticket ticket3 = new Ticket("Внуково", "Аднан Мендерес", 20_000, 1, 5);
    Ticket ticket4 = new Ticket("Кеннеди", "Гатвик", 18_000, 18, 6);
    Ticket ticket5 = new Ticket("Кеннеди", "Абу-Даби", 33_000, 14, 12);

    AviaSouls aviaSouls = new AviaSouls();

    @BeforeEach
    public void set() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void shouldSortTicketsFromMinPrice() {
        Arrays.sort(aviaSouls.findAll());
        Ticket[] expected = {ticket2, ticket1, ticket4, ticket3, ticket5};
        Ticket[] actual = aviaSouls.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
