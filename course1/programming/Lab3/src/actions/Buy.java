package actions;

import real.objects.Person;
import real.objects.items.Item;

public class Buy extends Action {
    public Buy(Person whoDoIt) {
        super(whoDoIt);
    }

    public void buy(int cost, Item item) {
        var person = item.getOwner();
        Give give = new Give(getWhoDoIt());
        give.giveMoney(cost, person);
        give.setWhoDoIt(person);
        give.changeOwner(item, getWhoDoIt());
    }

    @Override
    public String describe() {
        return "";
    }
}
