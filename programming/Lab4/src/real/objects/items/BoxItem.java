package real.objects.items;

import enums.Material;
import real.objects.Place;
import real.objects.Person;

import java.util.ArrayList;

public class BoxItem extends Item {
    private ArrayList<Item> contain = new ArrayList<>(1);
    private int money = 0;
    public BoxItem(String name, Person owner, Material material, Place place) {
        super(name, owner, material, place);
    }

    public ArrayList<Item> getContain() {
        return contain;
    }

    public void setContain(ArrayList<Item> contain) {
        this.contain = contain;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
