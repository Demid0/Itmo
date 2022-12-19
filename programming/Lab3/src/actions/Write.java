package actions;

import real.objects.Person;
import real.objects.items.RecordItem;

public class Write extends Action {
    public Write (Person whoDoIt) {
        super(whoDoIt);
    }

    public void addText(String s, RecordItem recordItem) {
        recordItem.setContain(recordItem.getContain() + " " + s);
        System.out.println(this.getWhoDoIt().getName() + describe() + s + " in " + recordItem.getName());
    }

    @Override
    public String describe() {
        return " write ";
    }
}
