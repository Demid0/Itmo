package actions;

import interfaces.Speakable;
import real.objects.Person;

import real.objects.items.SpeakableItem;
import system.CheckBadWords;
import system.myExceptions.CantMoveException;
import system.myExceptions.InterlocutorIsNotAround;

public class Say extends Action {
    private Speakable whoDoIt;
    public Say(Speakable whoDoIt) {
        super();
        this.whoDoIt = whoDoIt;
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
    public void say() {
        if (whoDoIt instanceof SpeakableItem) {
            System.out.println(((SpeakableItem) whoDoIt).getName() + describe() + ((SpeakableItem) whoDoIt).getNoise());
        }
    }
    @Override
    public String describe() {
        return " say: ";
    }

    public void setWhoDoIt(Speakable whoDoIt) {
        this.whoDoIt = whoDoIt;
    }
}
