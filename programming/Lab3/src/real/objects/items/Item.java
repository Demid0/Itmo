package real.objects.items;

import enums.Material;
import real.objects.Person;
import real.objects.RealObject;

import java.util.ArrayList;

public class Item extends RealObject {
    private Person owner;
    private final Material material;

    public Item(String name, Person owner, Material material) {
        setName(name);
        setOwner(owner);
        this.material = material;
        owner.getInventory().add(this);
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }
}
