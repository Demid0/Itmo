package actions;

import real.objects.alive.Person;
import system.myExceptions.InterlocutorIsNotAround;
import real.objects.*;
import real.objects.items.BoxItem;
import real.objects.items.Item;

import java.util.ArrayList;

public class Take extends Action {
    public Take(Person whoDoIt) {
        super(whoDoIt);
    }

    public void takeFromPlace(Item item, Place place) {
        try {
            if (getWhoDoIt().getWhereIsHe() != place) throw new InterlocutorIsNotAround();
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
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), place.getName()));
        }
    }

    public void takeFromBox(Item item, BoxItem box) {
        try {
            ArrayList<Item> container = box.getContain();
            if (getWhoDoIt().getWhereIsHe() != box.getWhereIsIt()) throw new InterlocutorIsNotAround();
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
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), box.getName()));
        }
    }

    @Override
    public String describe() {
        return getWhoDoIt().getName() + " take ";
    }
}
