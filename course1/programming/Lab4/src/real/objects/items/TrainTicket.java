package real.objects.items;

import real.objects.Person;
import system.CheckBadWords;

public class TrainTicket extends Ticket {
    private final String city;

    public TrainTicket(Person owner, int cost, int date, String city) {
        super(owner, cost, date);
        CheckBadWords.run(city);
        this.city = city;
    }
    public String getCity() {
        return city;
    }
}
