package real.objects.items;

import real.objects.Person;

public class CinemaTicket extends Ticket {
    private final String film;

    public CinemaTicket(String name, Person owner, int cost, int date, String film) {
        super(name, owner, cost, date);
        this.film = film;
    }
}
