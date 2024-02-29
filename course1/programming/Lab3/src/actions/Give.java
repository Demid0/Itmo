package actions;

import real.objects.items.BoxItem;
import real.objects.items.Item;
import real.objects.Person;
import real.objects.items.Money;

import java.util.ArrayList;

public class Give extends Action {

    public Give(Person whoDoIt) {
        super(whoDoIt);
    }

    public void changeOwner(Item item, Person person) {
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
    public void giveMoney(int nominal, Person person) {
        if (getWhoDoIt().getMoney().getNominal() >= nominal) {
            getWhoDoIt().getMoney().setNominal(getWhoDoIt().getMoney().getNominal() - nominal);
            person.getMoney().setNominal(person.getMoney().getNominal() + nominal);
            System.out.println(describe() + nominal + " fertings to " + person.getName());
        }
    }

    public void giveInBox(Item item, BoxItem box) {
        if (getWhoDoIt().getInventory().contains(item)) {
            box.getContain().add(item);
            System.out.println(describe() + item.getName() + " in " + box.getName());
        }
    }
    @Override
    public String describe() {
        return getWhoDoIt().getName() + " give ";
    }
}
