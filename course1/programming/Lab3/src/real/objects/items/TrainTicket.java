package real.objects.items;

import real.objects.Person;
import real.objects.items.Ticket;

public class TrainTicket extends Ticket {
    private final String city;

    public TrainTicket(String name, Person owner, int cost, int date, String city) {
        super(name, owner, cost, date);
        this.city = city;
    }
}
