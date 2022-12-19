package real.objects;

import real.objects.items.Item;
import real.objects.items.Money;

import java.util.ArrayList;

public class Person extends RealObject {
    private Place whereIsHe;
    private ArrayList<Item> inventory = new ArrayList<>(1);
    private final Money money = new Money("money", this, 5000);

    public Person(String name, Place whereIsHe) {
        setName(name);
        setWhereIsHe(whereIsHe);
        whereIsHe.getWhatIsWhere().add(this);
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Place getWhereIsHe() {
        return whereIsHe;
    }

    public void setWhereIsHe(Place whereIsHe) {
        this.whereIsHe = whereIsHe;
    }

    public Money getMoney() {
        return money;
    }
}
