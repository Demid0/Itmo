package real.objects.items;

import enums.Material;
import real.objects.Person;
import real.objects.items.Item;

public class Money extends Item {
    private int nominal;

    public Money(String name, Person owner, int nominal) {
        super(name, owner, Material.PAPER);
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
