package actions.topersons;

import actions.topersons.Action;
import system.myExceptions.CantMoveException;
import system.myExceptions.InterlocutorIsNotAround;
import real.objects.Person;
import real.objects.items.RecordItem;

public class Write extends Action {
    public Write (Person whoDoIt) {
        super(whoDoIt);
    }

    public void write(String s, RecordItem recordItem) {
        try {
            if (recordItem.getWhereIsIt() != getWhoDoIt().getWhereIsIt()) throw new InterlocutorIsNotAround();
            if (!getWhoDoIt().getBody().getHands().isCanMove()) throw new CantMoveException();
            recordItem.setContain(recordItem.getContain() + "\n" + s);
            System.out.println(this.getWhoDoIt().getName() + describe() + "\"" + s + "\"" + " in " + recordItem.getName());
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), recordItem.getName()));
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }

    }

    @Override
    public String describe() {
        return " write ";
    }
}
