package actions;

import real.objects.*;
import real.objects.items.BoxItem;
import real.objects.items.Item;

import java.util.ArrayList;

public class Take extends Action {
    public Take(Person whoDoIt) {
        super(whoDoIt);
    }

    public void takeFromPlace(Item item, Place place) {
        ArrayList<RealObject> container = place.getWhatIsWhere();
        if (container.contains(item)) {
            container.remove(item);
            place.setWhatIsWhere(container);
            item.setOwner(getWhoDoIt());

            ArrayList<Item> inventory = getWhoDoIt().getInventory();
            inventory.add(item);
            getWhoDoIt().setInventory(inventory);
            System.out.println(describe() + item.getName() + " from " + place.getName());
        }
    }

    public void takeFromBox(Item item, BoxItem box) {
        ArrayList<Item> container = box.getContain();
        if (container.contains(item)) {
            container.remove(item);
            box.setContain(container);
            item.setOwner(getWhoDoIt());

            container = getWhoDoIt().getInventory();
            container.add(item);
            getWhoDoIt().setInventory(container);

            System.out.println(describe() + item.getName() + " from " + box.getName());
        }
    }

    @Override
    public String describe() {
        return getWhoDoIt().getName() + " take ";
    }
}
