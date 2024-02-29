package actions.topersons;

import system.myExceptions.InterlocutorIsNotAround;
import real.objects.Person;
import real.objects.items.Item;

public class Buy extends Action {
    public Buy(Person whoDoIt) {
        super(whoDoIt);
    }

    public void buy(int cost, Item item) {
        if (cost < 0) cost = 500;
        Person person = item.getOwner();
        try {
            if (person.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            if (getWhoDoIt().getMoney() >= cost) {
                Give give = new Give(getWhoDoIt());
                give.give(cost, person);
                give.setWhoDoIt(person);
                give.give(item, getWhoDoIt());
            }
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
