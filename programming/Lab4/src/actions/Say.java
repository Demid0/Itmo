package actions;

import real.objects.alive.Person;

import system.CheckBadWords;
import system.myExceptions.InterlocutorIsNotAround;

public class Say extends Action {

    public Say(Person whoDoIt) {
        super(whoDoIt);
    }

    public void sayPhrase(String phrase, Person person) {
        CheckBadWords.run(phrase);
        try {
            System.out.println(getWhoDoIt().getName() + describe() + phrase);
            if (getWhoDoIt().getWhereIsHe() != person.getWhereIsHe()) throw new InterlocutorIsNotAround();
            Hear hear = new Hear(person);
            hear.hearPhrase(phrase);
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), person.getName()));
        }
    }

    @Override
    public String describe() {
        return " say: ";
    }
}
