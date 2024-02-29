package actions.topersons;

import actions.topersons.Action;
import real.objects.Person;
import system.myExceptions.CantMoveException;

public class Has extends Action {
    public Has(Person whoDoIt) {
        super(whoDoIt);
    }

    public void has(Condition condition) {
        try {
            if (condition == Condition.SMILE && !getWhoDoIt().getBody().getMouth().isCanMove()) throw new CantMoveException();
            getWhoDoIt().setCondition(condition);
            System.out.println(describe() + getWhoDoIt().getCondition());
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
