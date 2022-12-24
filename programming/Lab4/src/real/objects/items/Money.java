package real.objects.items;

import enums.Material;
import real.objects.alive.Person;

public class Money extends Item {
    private int nominal;

    public Money(Person owner, int nominal) {
        super("money", owner, Material.PAPER, owner.getWhereIsHe());
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
