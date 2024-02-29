package real.objects.items;

import enums.Material;
import real.objects.Person;
import real.objects.items.Item;

public class RecordItem extends Item {
    private String contain = "";

    public RecordItem(String name, Person owner) {
        super(name, owner, Material.PAPER);
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }
}
