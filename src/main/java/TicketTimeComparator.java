import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getFightTime() < o2.getFightTime()) {
            return -1;
        } else if (o1.getFightTime() > o2.getFightTime()) {
            return 1;
        }
        return 0;
    }
}