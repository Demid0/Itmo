package actions;

import real.objects.Person;

import java.util.ArrayList;

public class Say extends Action {

    public Say(Person whoDoIt) {
        super(whoDoIt);
    }

    public void sayPhrase(String phrase, Person person) {
        System.out.println(getWhoDoIt().getName() + describe() + phrase);
        Hear hear = new Hear(person);
        if (getWhoDoIt().getWhereIsHe() == person.getWhereIsHe()) hear.hearPhrase(phrase);
    }

    @Override
    public String describe() {
        return " say: ";
    }
}
