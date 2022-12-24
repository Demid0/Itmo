package actions;

import system.myExceptions.InterlocutorIsNotAround;
import real.objects.alive.Person;
import real.objects.items.RecordItem;

public class Write extends Action {
    public Write (Person whoDoIt) {
        super(whoDoIt);
    }

    public void addText(String s, RecordItem recordItem) {
        try {
            if (recordItem.getWhereIsIt() != getWhoDoIt().getWhereIsHe()) throw new InterlocutorIsNotAround();
            recordItem.setContain(recordItem.getContain() + " " + s);
            System.out.println(this.getWhoDoIt().getName() + describe() + "\"" + s + "\"" + " in " + recordItem.getName());
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), recordItem.getName()));
        }

    }

    @Override
    public String describe() {
        return " write ";
    }
}
