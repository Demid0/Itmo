package real.objects.items;

import real.objects.alive.Person;
import system.CheckBadWords;

public class CinemaTicket extends Ticket {
    private final String film;

    public CinemaTicket(Person owner, int cost, int date, String film) {
        super(owner, cost, date);
        CheckBadWords.run(film);
        this.film = film;
    }
}
