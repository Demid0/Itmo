package actions.topersons;

import actions.topersons.Action;
import actions.topersons.Hear;
import real.objects.Person;

import system.CheckBadWords;
import system.myExceptions.CantMoveException;
import system.myExceptions.InterlocutorIsNotAround;

public class Say extends Action {
    public Say(Person whoDoIt) {
        setWhoDoIt(whoDoIt);
    }

    public void say(String phrase, Person person) {
        try {
            if (!getWhoDoIt().getBody().getMouth().isCanMove()) throw new CantMoveException();
            CheckBadWords.run(phrase);
            System.out.println(getWhoDoIt().getName() + describe() + phrase);
            if (getWhoDoIt().getWhereIsIt() != person.getWhereIsIt()) throw new InterlocutorIsNotAround();
            Hear hear = new Hear(person);
            hear.hear(phrase);
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), person.getName()));
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }
    }

    @Override
    public String describe() {
        return " say: ";
    }

}
