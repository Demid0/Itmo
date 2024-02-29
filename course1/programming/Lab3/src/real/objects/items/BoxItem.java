package real.objects.items;

import enums.Material;
import real.objects.Person;

import java.util.ArrayList;

public class BoxItem extends Item {
    private ArrayList<Item> contain = new ArrayList<>(1);

    public BoxItem(String name, Person owner, Material material) {
        super(name, owner, material);
    }

    public ArrayList<Item> getContain() {
        return contain;
    }

    public void setContain(ArrayList<Item> contain) {
        this.contain = contain;
    }
}
