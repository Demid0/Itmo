package real.objects.items;

import enums.Material;
import real.objects.Place;
import real.objects.RealObject;
import real.objects.Person;

public class Item extends RealObject {
    private Person owner;
    private final Material material;

    public Item(String name, Person owner, Material material, Place place) {
        setName(name);
        setOwner(owner);
        setWhereIsIt(place);
        this.material = material;
    }
    public void setOwner(Person owner) {
        if (this.owner != null) {
            var inventory = this.owner.getInventory();
            inventory.remove(this);
            this.owner.setInventory(inventory);
            this.owner = owner;
            inventory = this.owner.getInventory();
            inventory.add(this);
            this.owner.setInventory(inventory);
        }
        else {
            this.owner = owner;
            var inventory = this.owner.getInventory();
            inventory.add(this);
            this.owner.setInventory(inventory);
        }
    }

    public Person getOwner() {
        return owner;
    }



    public Material getMaterial() {
        return material;
    }
}
