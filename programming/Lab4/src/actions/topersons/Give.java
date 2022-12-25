package actions.topersons;

import actions.topersons.Action;
import system.myExceptions.CantMoveException;
import system.myExceptions.InterlocutorIsNotAround;
import real.objects.items.BoxItem;
import real.objects.items.Item;
import real.objects.Person;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Give extends Action {

    public Give(Person whoDoIt) {
        super(whoDoIt);
    }

    public void give(Item item, Person person) {
        try {
            if (person.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            if (!getWhoDoIt().getBody().getHands().isCanMove()) throw new CantMoveException();
            ArrayList<Item> inventory = getWhoDoIt().getInventory();
            if (inventory.contains(item)) {
                inventory.remove(item);
                item.setOwner(person);
                getWhoDoIt().setInventory(inventory);

                inventory = person.getInventory();
                inventory.add(item);
                person.setInventory(inventory);

                System.out.println(describe() + item.getName() + " to " + person.getName());
            }
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), person.getName()));
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }

    }
    public void give(int nominal, Person person) {
        try {
            if (person.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            if (getWhoDoIt().getMoney() >= nominal) {
                getWhoDoIt().setMoney(getWhoDoIt().getMoney() - nominal);
                person.setMoney(person.getMoney() + nominal);
                System.out.println(describe() + nominal + " fertings to " + person.getName());
            }
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), person.getName()));
        }

    }
    public void give(Item item, BoxItem box) {
        try {
            if (box.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            if (getWhoDoIt().getInventory().contains(item)) {
                box.getContain().add(item);
                System.out.println(describe() + item.getName() + " in " + box.getName());
            }
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), box.getName()));
        }
    }
    public void give(int money, BoxItem box) {
        try {
            if (box.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            money = min(money, getWhoDoIt().getMoney());
            box.setMoney(box.getMoney() + money);
            getWhoDoIt().setMoney(getWhoDoIt().getMoney() - money);
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), box.getName()));
        }
    }
    @Override
    public String describe() {
        return getWhoDoIt().getName() + " give ";
    }
}
