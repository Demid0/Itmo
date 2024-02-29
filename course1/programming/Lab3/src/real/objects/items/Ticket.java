package real.objects.items;

import enums.Material;
import real.objects.Person;
import real.objects.items.Item;

public class Ticket extends Item {
    private final int cost;
    private final int date;

    public Ticket(String name, Person owner, int cost, int date) {
        super(name, owner, Material.PAPER);
        this.cost = cost;
        this.date = date;
    }

    public void getDate() {
        int dd = date / 1000000;
        int mm = date / 10000 - dd * 100;
        int yyyy = date - (dd * 100 + mm) * 10000;
        System.out.println(dd + "." + mm + "." + yyyy);
    }

    public int getCost() {
        return cost;
    }
}
