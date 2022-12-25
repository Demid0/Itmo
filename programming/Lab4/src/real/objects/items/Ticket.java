package real.objects.items;

import enums.Material;
import real.objects.Person;

public class Ticket extends Item {
    private final int cost;
    private final int date;

    public Ticket(Person owner, int cost, int date) {
        super("Билет", owner, Material.PAPER, owner.getWhereIsIt());
        if(cost >= 0) this.cost = cost;
        else this.cost = 500;
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
