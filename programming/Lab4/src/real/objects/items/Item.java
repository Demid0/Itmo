package real.objects.items;

import enums.Material;
import real.objects.alive.Person;
import real.objects.Place;
import real.objects.RealObject;

public class Item extends RealObject {
    private Person owner;
    private final Material material;
    private Place whereIsIt;

    public Item(String name, Person owner, Material material, Place place) {
        setName(name);
        setOwner(owner);
        setWhereIsIt(place);
        this.material = material;
        owner.getInventory().add(this);
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public Place getWhereIsIt() {
        return whereIsIt;
    }

    public void setWhereIsIt(Place whereIsIt) {
        this.whereIsIt = whereIsIt;
    }

    public Material getMaterial() {
        return material;
    }
}
