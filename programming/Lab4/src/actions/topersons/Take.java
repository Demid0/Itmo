package actions.topersons;

import actions.topersons.Action;
import real.objects.Place;
import real.objects.RealObject;
import real.objects.Person;
import system.myExceptions.CantMoveException;
import system.myExceptions.InterlocutorIsNotAround;
import real.objects.items.BoxItem;
import real.objects.items.Item;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Take extends Action {
    public Take(Person whoDoIt) {
        super(whoDoIt);
    }
    public void take(Item item, Place place) {
        try {
            if (getWhoDoIt().getWhereIsIt() != place) throw new InterlocutorIsNotAround();
            checkHands();
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

    public void take(Item item, BoxItem box) {
        try {
            ArrayList<Item> container = box.getContain();
            if (getWhoDoIt().getWhereIsIt() != box.getWhereIsIt()) throw new InterlocutorIsNotAround();
            checkHands();
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
    public void take(int money, BoxItem box) {
        try {
            if (getWhoDoIt().getWhereIsIt() != box.getWhereIsIt()) throw new InterlocutorIsNotAround();
            checkHands();
            money = min(money, box.getMoney());
            getWhoDoIt().setMoney(getWhoDoIt().getMoney() + money);
            System.out.println(describe() + money + " fertings from " + box.getName());
            box.setMoney(box.getMoney() - money);
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), box.getName()));
        }
    }

    private void checkHands() {
        try {
        if (!getWhoDoIt().getBody().getHands().isCanMove()) throw new CantMoveException();
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }
    }

    @Override
    public String describe() {
        return getWhoDoIt().getName() + " take ";
    }
}
