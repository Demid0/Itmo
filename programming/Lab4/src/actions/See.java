package actions;

import real.objects.Place;
import real.objects.RealObject;
import real.objects.Person;
import system.InvokeMethod;
import system.myExceptions.InterlocutorIsNotAround;

public class See extends Action{

    public See(Person whoDoIt) {
        super(whoDoIt);
    }

    public void see(RealObject object) {
        try {
            if(getWhoDoIt().getWhereIsIt() != object.getWhereIsIt()) throw new InterlocutorIsNotAround();
            System.out.println(describe() + object.getName());
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), object.getName()));
        }
    }
    public void see(Action action, String method, Person whoDoAction, Object[] parameters) {
        try {
            if(getWhoDoIt().getWhereIsIt() != whoDoAction.getWhereIsIt() && !(getWhoDoIt().getWhereIsIt() == Place.Default || whoDoAction.getWhereIsIt() == Place.Default)) throw new InterlocutorIsNotAround();
            System.out.print(describe());
            InvokeMethod.invoke(action, method, whoDoAction, parameters);
        }
        catch (InterlocutorIsNotAround ex) {
            System.out.println(ex.getMessage(getWhoDoIt().getName(), whoDoAction.getName()));
        }

    }
    public void takeAlias(RealObject alias) {
        System.out.print("look like " + alias.getName() + "\n");
    }
    public void takeAlias(Action action, String method, Person whoDoIt, Object[] parameters) {
        System.out.print("look like ");
        InvokeMethod.invoke(action, method, whoDoIt, parameters);
    }


    @Override
    public String describe() {
        return getWhoDoIt().getName() + " see ";
    }
}
