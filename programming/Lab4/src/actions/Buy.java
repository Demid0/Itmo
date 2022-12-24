package actions;

import system.myExceptions.InterlocutorIsNotAround;
import real.objects.alive.Person;
import real.objects.items.Item;

public class Buy extends Action {
    public Buy(Person whoDoIt) {
        super(whoDoIt);
    }

    public void buy(int cost, Item item) {
        Person person = item.getOwner();
        try {
            if (person.getWhereIsHe() != getWhoDoIt().getWhereIsHe()) throw new InterlocutorIsNotAround();
            Give give = new Give(getWhoDoIt());
            give.giveMoney(cost, person);
            give.setWhoDoIt(person);
            give.changeOwner(item, getWhoDoIt());
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), person.getName()));
        }
    }

    @Override
    public String describe() {
        return "";
    }
}
