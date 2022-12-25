package actions;

import real.objects.Person;
import system.myExceptions.CantMoveException;

public class Has extends Action {
    public Has(Person whoDoIt) {
        super(whoDoIt);
    }

    public void has(Condition condition) {
        try {
            if (condition == Condition.SMILE && !getWhoDoIt().getBody().getMouth().isCanMove()) throw new CantMoveException();
            System.out.println(describe() + condition);
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }

    }

    @Override
    public String describe() {
        return getWhoDoIt().getName() + " has ";
    }

    public enum Condition {
        SMILE, SAD, PAIN, DEFAULT, HUMILITY, HAPPY
    }
}
