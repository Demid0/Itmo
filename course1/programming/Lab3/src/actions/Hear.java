package actions;

import real.objects.Person;

public class Hear extends Action {

    public Hear(Person whoDoIt) {
        super(whoDoIt);
    }
    public void hearPhrase(String phrase) {
        System.out.println(getWhoDoIt().getName() + describe() + phrase);
    }
    @Override
    public String describe() {
        return " hear: ";
    }
}
